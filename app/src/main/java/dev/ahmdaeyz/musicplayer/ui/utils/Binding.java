package dev.ahmdaeyz.musicplayer.ui.utils;

import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;

import java.util.Optional;

import jp.wasabeef.glide.transformations.CropCircleWithBorderTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class Binding {

    public static void bindImageViewWithRoundedCorners(@NonNull ImageView imageView,@NonNull String url, Optional<Integer> radius) {
        Glide.with(imageView)
                .load(url)
                .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(radius.orElse(20),0, RoundedCornersTransformation.CornerType.ALL)))
                .into(imageView);
    }

    public static void bindCircleImageView(@NonNull ImageView imageView,@NonNull String url,int color, int borderSize){
        Glide.with(imageView)
                .load(url)
                .apply(RequestOptions.bitmapTransform(new CropCircleWithBorderTransformation(borderSize,color)))
                .into(imageView);
    }
}
