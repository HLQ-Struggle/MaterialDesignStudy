package com.materialdesignstudy.paletter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.materialdesignstudy.R;

/**
 * Palette 调色板使用
 * 需要引入v7包
 * 作用：1.分析图片色彩的特性，例如主色调以及各种颜色等
 * create by heliquan at 2017年11月13日
 */
public class PaletteActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        // 将ActionBar替换为Toolbar
        setSupportActionBar(mToolbar);
        initView();
    }

    private void initView() {
        mImageView = (ImageView) findViewById(R.id.id_image);

        BitmapDrawable drawable = (BitmapDrawable) mImageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        // 拿到图片 生成调色板
        // 通过Palette分析 得到色彩信息
//        Palette palette=Palette.generate(bitmap);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                // 分析图片中 较暗、柔和的颜色
                // 分析不出来显示默认
                int darkMutedColor = palette.getDarkMutedColor(Color.BLUE);
                // 分析图片中 比较暗、柔和的颜色
                int lightMutedColor = palette.getLightMutedColor(Color.BLUE);
                // 分析图片中 比较暗、鲜艳的颜色
                int darkVibrantColor = palette.getDarkVibrantColor(Color.BLUE);
                // 分析图片中 比较亮、鲜艳的颜色
                int lightVibrantColor = palette.getLightVibrantColor(Color.BLUE);
                // 柔和
                int mutedColor = palette.getMutedColor(Color.BLUE);
                // 载体
                Palette.Swatch lightVibrantSwatch = palette.getLightMutedSwatch();
                // 获取谷歌提供推荐颜色 RGB
                int rgb = lightVibrantSwatch.getRgb();
                // 谷歌推荐作为 图片标题颜色(基于图片对比度所呈现的颜色值)
                int titleColor = lightVibrantSwatch.getTitleTextColor();
                // 谷歌推荐作为 图片中间文字颜色
                int bodyColor = lightVibrantSwatch.getBodyTextColor();
                // 颜色向量
                float[] hsl = lightVibrantSwatch.getHsl();
                // 分析颜色在图片所占的像素值
                int population = lightVibrantSwatch.getPopulation();

                findViewById(R.id.id_title).setBackgroundColor(darkMutedColor);
                findViewById(R.id.id_title1).setBackgroundColor(lightMutedColor);
                findViewById(R.id.id_title2).setBackgroundColor(darkVibrantColor);
                findViewById(R.id.id_title3).setBackgroundColor(lightVibrantColor);
                findViewById(R.id.id_title4).setBackgroundColor(rgb);
                findViewById(R.id.id_title5).setBackgroundColor(titleColor);
                findViewById(R.id.id_title6).setBackgroundColor(bodyColor);
                findViewById(R.id.id_title7).setBackgroundColor(getTranslucentColor(0.5f, rgb));
            }

        });

        initImg1();
        initImg2();

        initYZ();

        initZS();
        initXX();

    }

    /**
     * 设置圆角弧度以及渐变
     *
     * @param startRGB
     * @param endRGB
     * @return
     */
    private Drawable getImageViewShape(int startRGB, int endRGB) {
        GradientDrawable shape = new GradientDrawable(GradientDrawable.Orientation.TL_BR
                , new int[]{startRGB, endRGB});
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        shape.setCornerRadius(8);
        return shape;
    }

    private void initXX() {
        ImageView iv = (ImageView) findViewById(R.id.iv_bank);
        Bitmap bitmap = ((BitmapDrawable) iv.getDrawable()).getBitmap();
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                // 载体
                Palette.Swatch lightVibrantSwatch = palette.getLightMutedSwatch();
                LinearLayout ll = (LinearLayout) findViewById(R.id.ll_bank);
                ((TextView) findViewById(R.id.tv_bank)).setTextColor(lightVibrantSwatch.getTitleTextColor());
                ll.setBackgroundColor(palette.getDarkVibrantColor(Color.BLUE));
                ll.setBackground(getImageViewShape(palette.getVibrantColor(Color.BLUE), palette.getDarkVibrantColor(Color.BLUE)));
            }

        });
    }

    private void initZS() {
        ImageView iv = (ImageView) findViewById(R.id.iv_zs);
        Bitmap bitmap = ((BitmapDrawable) iv.getDrawable()).getBitmap();
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                // 载体
                Palette.Swatch lightVibrantSwatch = palette.getLightMutedSwatch();
                LinearLayout ll = (LinearLayout) findViewById(R.id.ll_zs);
                ((TextView) findViewById(R.id.tv_zs)).setTextColor(lightVibrantSwatch.getTitleTextColor());
                ll.setBackgroundColor(palette.getDarkVibrantColor(Color.BLUE));
            }

        });
    }

    private void initYZ() {
        BitmapDrawable drawable = (BitmapDrawable) ((ImageView) findViewById(R.id.iv_yz)).getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                // 载体
                Palette.Swatch lightVibrantSwatch = palette.getLightMutedSwatch();
                LinearLayout ll = (LinearLayout) findViewById(R.id.ll_yz);
                ((TextView) findViewById(R.id.tv_yz)).setTextColor(lightVibrantSwatch.getTitleTextColor());
                ll.setBackgroundColor(palette.getDarkVibrantColor(Color.BLUE));
            }

        });
    }

    private void initImg2() {
        BitmapDrawable drawable = (BitmapDrawable) ((ImageView) findViewById(R.id.id_image_test2)).getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                // 载体
                Palette.Swatch lightVibrantSwatch = palette.getLightMutedSwatch();
                TextView tv = (TextView) findViewById(R.id.id_text2);
                tv.setTextColor(lightVibrantSwatch.getTitleTextColor());
                tv.setBackgroundColor(palette.getLightVibrantColor(Color.BLUE));
            }

        });
    }

    private void initImg1() {
        ImageView iv = (ImageView) findViewById(R.id.id_image_test1);
        BitmapDrawable drawable = (BitmapDrawable) iv.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        // 拿到图片 生成调色板
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                // 载体
                Palette.Swatch lightVibrantSwatch = palette.getLightMutedSwatch();
                TextView tv = (TextView) findViewById(R.id.id_text1);
                tv.setTextColor(lightVibrantSwatch.getTitleTextColor());
                tv.setBackgroundColor(getTranslucentColor(0.5f, palette.getLightVibrantColor(Color.BLUE)));
            }

        });
    }

    /**
     * 1101 0111 1000 1011
     * 依次代表 a r g b 通过位移 得出实际结果
     *
     * @param percent 百分比 比例
     * @param rgb
     * @return
     */
    private int getTranslucentColor(float percent, int rgb) {
        // 方式一：使用谷歌推荐方式 效率更高
        // 关于运算 可以直接源码查看
//        int alpha = rgb >>> 24;
//        int red = rgb >> 16 & 0xff;
//        int green = rgb >> 8 & 0xff;
//        int blue = rgb & 0xff;

        // 方式二：使用提供Api
        int alpha = Color.alpha(rgb);
        int blue = Color.blue(rgb);
        int red = Color.red(rgb);
        int green = Color.green(rgb);

        alpha = Math.round(alpha * percent);
        return Color.argb(alpha, red, green, blue);
    }

}
