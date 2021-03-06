package com.fongmi.bear.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.view.View;

import androidx.viewbinding.ViewBinding;

import com.fongmi.bear.ApiConfig;
import com.fongmi.bear.databinding.ActivitySplashBinding;
import com.fongmi.bear.net.Callback;
import com.fongmi.bear.utils.Notify;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends BaseActivity {

    private ActivitySplashBinding binding;

    @Override
    protected ViewBinding getBinding() {
        return binding = ActivitySplashBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        binding.title.animate().alpha(1).setDuration(2000).setListener(onAnimationEnd()).start();
    }

    private AnimatorListenerAdapter onAnimationEnd() {
        return new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                binding.title.setVisibility(View.GONE);
                binding.progress.animate().alpha(1).setDuration(500).start();
                binding.info.animate().alpha(1).setDuration(500).start();
                loadConfig();
            }
        };
    }

    private void loadConfig() {
        ApiConfig.get().loadConfig(new Callback() {
            @Override
            public void success() {
                HomeActivity.start(getActivity());
            }

            @Override
            public void error(String msg) {
                HomeActivity.start(getActivity());
                Notify.show(msg);
            }
        });
    }
}
