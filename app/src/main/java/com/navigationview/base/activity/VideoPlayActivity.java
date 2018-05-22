package com.navigationview.base.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import com.navigationview.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoPlayActivity extends AppCompatActivity {
    @BindView(R.id.videoplayer)
    JCVideoPlayerStandard jcVideoPlayerStandard;
    @OnClick(R.id.btn_small)
    void button(){
        jcVideoPlayerStandard.startWindowTiny();
    }
    @BindView(R.id.vide_view)
    VideoView videoView;
    MediaController mController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        ButterKnife.bind(this);
        jcVideoPlayerStandard.setUp("http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4", JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "播放标题");
        Picasso.with(this).load("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640").into(jcVideoPlayerStandard.thumbImageView);

        // 创建MediaController对象
        mController = new MediaController(this);
        Uri uri=Uri.parse("http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4");
            videoView.setVideoURI(uri); // ①
            // 设置videoView和mController建立关联
            videoView.setMediaController(mController); // ②
            // 设置mController和videoView建立关联
            mController.setMediaPlayer(videoView); // ③
            // 让VideoView获取焦点
            videoView.requestFocus();
    }
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
