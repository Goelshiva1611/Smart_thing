package com.example.smarthomecarapp;

import android.graphics.drawable.Icon;
import androidx.annotation.NonNull;
import androidx.car.app.CarContext;
import androidx.car.app.Screen;
import androidx.car.app.model.CarIcon;
import androidx.car.app.model.CarText;
import androidx.car.app.model.GridItem;
import androidx.car.app.model.GridTemplate;
import androidx.car.app.model.Header;
import androidx.car.app.model.ItemList;
import androidx.car.app.model.Template;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.List;

public class SmartHomeScreen extends Screen {

    public SmartHomeScreen(@NonNull CarContext carContext) {
        super(carContext);
    }

    @NonNull
    @Override
    public Template onGetTemplate() {
        List<GridItem> gridItems = new ArrayList<>();

        gridItems.add(new GridItem.Builder()
                .setImage(new CarIcon.Builder(
                        IconCompat.createWithResource(getCarContext(), R.drawable.ic_desk_light))
                        .build(), GridItem.IMAGE_TYPE_LARGE)
                .setTitle("Desk light")
                .setText("On")
                .build());

        gridItems.add(new GridItem.Builder()
                .setImage(new CarIcon.Builder(
                        IconCompat.createWithResource(getCarContext(), R.drawable.ic_globe))
                        .build(), GridItem.IMAGE_TYPE_LARGE)
                .setTitle("Globe")
                .setText("Off")
                .build());

        gridItems.add(new GridItem.Builder()
                .setImage(new CarIcon.Builder(
                        IconCompat.createWithResource(getCarContext(), R.drawable.ic_security))
                        .build(), GridItem.IMAGE_TYPE_LARGE)
                .setTitle("Security")
                .setText("Armed (away)")
                .build());

        ItemList itemList = new ItemList.Builder()
                .setItems(gridItems)
                .build();

        return new GridTemplate.Builder()
                .setSingleList(itemList)
                .setHeader(new Header.Builder()
                        .setTitle(CarText.create("Smart Home"))
                        .build())
                .setItemSize(GridTemplate.ITEM_SIZE_LARGE)
                .setItemImageShape(GridTemplate.ITEM_IMAGE_SHAPE_CIRCLE)
                .build();
    }
}