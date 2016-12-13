package com.edsapps.carlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.edsapps.carlist.model.CarResponse;
import com.edsapps.carlist.model.VehAvail;
import com.edsapps.carlist.model.VehRentalCore;
import com.edsapps.carlist.model.VehVendorAvail;
import com.edsapps.carlist.model.VehVendorDTO;
import com.edsapps.carlist.utility.CarService;
import com.squareup.picasso.Picasso;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * An activity representing a list of Cars. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link CarDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class CarListActivity extends AppCompatActivity {

    public static final Map<String, VehVendorDTO> ITEM_MAP = new HashMap<>();

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    private TextView pickupDate;
    private TextView pickupLocation;
    private TextView returnLocation;
    private TextView returnDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

        pickupDate = (TextView) findViewById(R.id.pickupDate);
        pickupLocation = (TextView) findViewById(R.id.pickupLocation);
        returnDate = (TextView) findViewById(R.id.returnDate);
        returnLocation = (TextView) findViewById(R.id.returnLocation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        RecyclerView recyclerView =  (RecyclerView) findViewById(R.id.car_list);
        assert recyclerView != null;

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);

        DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(), mLayoutManager.getOrientation());
        recyclerView.addItemDecoration(divider);

        setupRecyclerView(recyclerView);

        if (findViewById(R.id.car_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }


    }

    private void setupRecyclerView(@NonNull final RecyclerView recyclerView) {
        Call<List<CarResponse>> forecastCall = CarService.getInstance().getCarService();
        forecastCall.enqueue(new Callback<List<CarResponse>>() {
            @Override
            public void onResponse(Call<List<CarResponse>> call, Response<List<CarResponse>> response) {
                if (response.isSuccessful()) {
                    int i = 0;
                    ITEM_MAP.clear();

                    if (response.body().size() == 0) {
                        // Show some error message
                        return;
                    }

                    for (VehVendorAvail item: response.body().get(0).getVehAvailRSCore().getVehVendorAvails()) {

                        for (VehAvail part: item.getVehAvails()) {
                            VehVendorDTO dto = new VehVendorDTO(Integer.toString(i), item.getVendor(), part);
                            ITEM_MAP.put(Integer.toString(i++), dto);
                        }
                    }
                    VehRentalCore core = response.body().get(0).getVehAvailRSCore().getVehRentalCore();

                    DateTime pickupDateTime = new DateTime(core.getPickUpDateTime());
                    DateTime returnDateTime = new DateTime(core.getReturnDateTime());
                    pickupDate.setText(pickupDateTime.toString("dd/MM/YYYY HH:mm"));
                    pickupLocation.setText(core.getPickUpLocation().getName());
                    returnDate.setText(returnDateTime.toString("dd/MM/YYYY HH:mm"));
                    returnLocation.setText(core.getReturnLocation().getName());

                    ArrayList toSort = new ArrayList(ITEM_MAP.values());
                    Collections.sort(toSort, new VehPriceComparator());
                    recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(toSort));

                } else {
                    Snackbar.make(recyclerView, "Unable to retrieve data", Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<CarResponse>> call, Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
            }
        });


    }

    private class VehPriceComparator implements Comparator<VehVendorDTO> {
        @Override
        public int compare(VehVendorDTO o1, VehVendorDTO o2) {

            Double totalAmount1 = Double.valueOf(o1.getVendorAvail().getTotalCharge().getEstimatedTotalAmount());
            Double totalAmount2 = Double.valueOf(o2.getVendorAvail().getTotalCharge().getEstimatedTotalAmount());
            return totalAmount1.compareTo(totalAmount2);
        }
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<VehVendorDTO> mValues;

        public SimpleItemRecyclerViewAdapter(List<VehVendorDTO> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.car_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);

            holder.tagLine.setText(
                    mValues.get(position).getVendorAvail().getStatus() + " " +
                    mValues.get(position).getVendor().getName() + " " +
                    mValues.get(position).getVendor().getCode() + " " +
                    mValues.get(position).getVendorAvail().getVehicle().getCode() + " " +
                    mValues.get(position).getVendorAvail().getVehicle().getFuelType() + " " +
                    mValues.get(position).getVendorAvail().getVehicle().getTransmissionType()
            );
            holder.vehMakeModelName.setText(mValues.get(position).getVendorAvail().getVehicle().getVehMakeModel().getName());
            holder.baggageQuantity.setText(mValues.get(position).getVendorAvail().getVehicle().getBaggageQuantity() + " Pieces"); // TODO externalize strings
            holder.totalAmount.setText(mValues.get(position).getVendorAvail().getTotalCharge().getRateTotalAmount());
            holder.currencyCode.setText(mValues.get(position).getVendorAvail().getTotalCharge().getCurrencyCode());
            holder.doorCount.setText(mValues.get(position).getVendorAvail().getVehicle().getDoorCount() + " Doors"); //// TODO externalize strings
            holder.passengerQuantity.setText(mValues.get(position).getVendorAvail().getVehicle().getPassengerQuantity() + " Passengers"); // // TODO externalize strings
            Picasso.with(CarListActivity.this).
                    load(mValues.get(position).getVendorAvail().getVehicle().getPictureURL()).
                    resize(500, 500).centerInside().into(holder.imageView);

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(CarDetailFragment.ARG_ITEM_ID, holder.mItem.getVehVendorId());
                        CarDetailFragment fragment = new CarDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.car_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, CarDetailActivity.class);
                        intent.putExtra(CarDetailFragment.ARG_ITEM_ID, holder.mItem.getVehVendorId());

                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            VehVendorDTO mItem;
            final View mView;
            final TextView tagLine;
            final ImageView imageView;

            final TextView baggageQuantity;
            final TextView totalAmount;
            final TextView currencyCode;
            final TextView doorCount;
            final TextView vehMakeModelName;
            final TextView passengerQuantity;

            ViewHolder(View view) {
                super(view);
                mView = view;
                baggageQuantity = (TextView) view.findViewById(R.id.baggage_quantity);
                tagLine = (TextView) view.findViewById(R.id.tag_line);
                totalAmount = (TextView) view.findViewById(R.id.total_amount);
                currencyCode = (TextView) view.findViewById(R.id.currency_code);
                doorCount = (TextView) view.findViewById(R.id.doorCount);
                vehMakeModelName = (TextView) view.findViewById(R.id.veh_make_model_name);
                imageView = (ImageView) view.findViewById(R.id.pictureURL);
                passengerQuantity = (TextView) view.findViewById(R.id.passenger_quantity);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + tagLine.getText() + "'";
            }
        }
    }
}
