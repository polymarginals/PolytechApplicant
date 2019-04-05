package ru.spbstu.abit.base.home.menu.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public class MenuListItem implements Parcelable {
    private String title;
    private int iconId;
    private int iconColorId;
    private int iconBackgroundColorId;

    public MenuListItem(
            String title,
            int iconId,
            int iconColorId,
            int iconBackgroundColorId
    ) {
        this.title = title;
        this.iconId = iconId;
        this.iconColorId = iconColorId;
        this.iconBackgroundColorId = iconBackgroundColorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public int getIconColorId() {
        return iconColorId;
    }

    public void setIconColorId(int iconColorId) {
        this.iconColorId = iconColorId;
    }

    public int getIconBackgroundColorId() {
        return iconBackgroundColorId;
    }

    public void setIconBackgroundColorId(int iconBackgroundColorId) {
        this.iconBackgroundColorId = iconBackgroundColorId;
    }

    @NonNull
    @Override
    public String toString() {
        return "MenuListItem {\n" +
                "\ttitle = '" + title + '\'' + '\n' +
                "\ticonId = " + iconId + '\n' +
                "\ticonColorId = " + iconColorId + '\n' +
                "\ticonBackgroundColorId = " + iconBackgroundColorId + '\n' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(iconId);
        dest.writeInt(iconColorId);
        dest.writeInt(iconBackgroundColorId);
    }

    public static final Parcelable.Creator<MenuListItem> CREATOR = new Parcelable.Creator<MenuListItem>() {
        public MenuListItem createFromParcel(Parcel in) {
            return new MenuListItem(in);
        }

        public MenuListItem[] newArray(int size) {
            return new MenuListItem[size];
        }
    };

    // конструктор, считывающий данные из Parcel
    private MenuListItem(Parcel parcel) {
        title = parcel.readString();
        iconId = parcel.readInt();
        iconColorId = parcel.readInt();
        iconBackgroundColorId = parcel.readInt();
    }
}
