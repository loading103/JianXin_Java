package com.rhby.edu.jianxin.ui.activity.mvp.presenter;


import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;

import com.congda.baselibrary.mvp.BasePresenter;
import com.congda.baselibrary.utils.IMSavePhotoUtil;
import com.congda.baselibrary.utils.glide.IMChooseUtils;
import com.congda.baselibrary.widget.dialog.IMSheetDialog;
import com.donkingliang.imageselector.utils.ImageSelector;
import com.rhby.edu.jianxin.ui.activity.mvp.contract.DemoContract;
import com.rhby.edu.jianxin.ui.activity.mvp.model.DemoModel;
import com.rhby.edu.jianxin.ui.activity.mvp.view.DemoActivity;

import java.util.ArrayList;
import java.util.List;

import cc.shinichi.library.ImagePreview;
import cc.shinichi.library.bean.ImageInfo;
import cc.shinichi.library.view.listener.OnBigImageClickListener;
import cc.shinichi.library.view.listener.OnBigImageLongClickListener;
import cc.shinichi.library.view.listener.OnBigImagePageChangeListener;

/**
 * @author：jianxin
 * 创建时间：2020/7/30
 */
public class DemoPresenter extends BasePresenter<DemoContract.Model,DemoContract.View> implements OnBigImagePageChangeListener {


    @Override
    protected DemoContract.Model createModel() {
        return new DemoModel();
    }


    public void showSheetView(DemoActivity demoActivity) {
        new IMSheetDialog.Builder(demoActivity)
                .addSheet("拍照", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        ImageSelector.builder()
                                .setCrop(true) // 设置是否使用图片剪切功能。
                                .setCropRatio(1.0f) // 图片剪切的宽高比,默认1.0f。宽固定为手机屏幕的宽。
                                .onlyTakePhoto(true) // 仅拍照，不打开相册
                                .start(demoActivity,10002);
                    }
                })
                .addSheet("选择图片", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        IMChooseUtils.choosePhotoForResult(demoActivity,10001,9);
                    }
                }).create().show();;
    }


    /**
     * 图片浏览
     */
    public void showBigImageView(DemoActivity demoActivity) {
        List<ImageInfo> imageInfoList = new ArrayList<>();
        ImageInfo imageInfo = new ImageInfo();
        imageInfo.setOriginUrl("http://65.52.160.124:9050/group1/M00/00/55/CgABFV6buVuAZCFqAAIImhjoeGY62.jpeg");
        imageInfo.setThumbnailUrl("http://65.52.160.124:9050/group1/M00/00/55/CgABFV6buVuADaMRAAAOyggtizU42.jpeg");
        imageInfoList.add(0, imageInfo);

        ImageInfo imageInfo1 = new ImageInfo();
        imageInfo1.setOriginUrl("http://65.52.160.124:9050/group1/M00/00/55/CgABFV6buX2ASWhNAAFvQV_a_HU53.jpeg");
        imageInfo1.setThumbnailUrl("http://65.52.160.124:9050/group1/M00/00/55/CgABFV6buX2AaOV8AAAXF06XiH860.jpeg");
        imageInfoList.add(0, imageInfo1);

        ImageInfo imageInfo2 = new ImageInfo();
        imageInfo2.setOriginUrl("http://65.52.160.124:9050/group1/M00/00/55/CgABFV6buX2AD-7EAAEOr8qHdJk72.jpeg");
        imageInfo2.setThumbnailUrl("http://65.52.160.124:9050/group1/M00/00/55/CgABFV6buX2AEwwDAAAfXguPxv477.jpeg");
        imageInfoList.add(0, imageInfo2);


        ImagePreview.getInstance() // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
                .setContext(demoActivity)
                .setLoadStrategy(ImagePreview.LoadStrategy.Default)
                .setZoomTransitionDuration(1000)
                .setImageInfoList(imageInfoList) //设置是否显示下载按钮
                //设置是否显示下载按钮
                .setShowDownButton(false)
                .setBigImageClickListener(new OnBigImageClickListener() {
                    @Override
                    public void onClick(Activity activity, View view, int position) {

                    }
                })
                .setBigImageLongClickListener(new OnBigImageLongClickListener() {
                    @Override
                    public boolean onLongClick(Activity activity, View view, int position) {
                        handleBigImageLongClickListener(activity,position,imageInfoList);
                        return false;
                    }
                })
                .setBigImagePageChangeListener(this)
                .start();
    }

    /**
     * 长按图片处理
     */
    private void handleBigImageLongClickListener(Activity activity, int i,List<ImageInfo> imageInfoList) {
        new IMSheetDialog.Builder(activity)
                .addSheet("保存图片", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        IMSavePhotoUtil.saveUrlToPhoto(activity,imageInfoList.get(i).getOriginUrl(),null);
                    }
                })
                .addSheet("分享好友", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
