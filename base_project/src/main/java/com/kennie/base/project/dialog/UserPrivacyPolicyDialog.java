package com.kennie.base.project.dialog;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import com.kennie.project.R;


/**
 * @项目名 KennieProject
 * @类名称 UserPrivacyPolicyDialog
 * @类描述 用户隐私政策对话框
 * @创建人 Kennie
 * @修改人
 * @创建时间 2021/11/17 23:11
 */
public class UserPrivacyPolicyDialog {

    private static String TAG = UserPrivacyPolicyDialog.class.getSimpleName();


    /**
     * 显示隐私政策弹框
     *
     * @param context
     * @param clickListener
     */
    public static void show(Context context, View.OnClickListener clickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = View.inflate(context, R.layout.dialog_user_privacy_policy, null);
        AppCompatTextView tv_agree = view.findViewById(R.id.tv_agree);
        AppCompatTextView tv_content = view.findViewById(R.id.tv_content);
        AppCompatTextView tv_close_app = view.findViewById(R.id.tv_close_app);
        SpannableString doubleClickTag = getDoubleClickTag(context,
                R.color.red,
                context.getString(R.string.dialog_user_privacy_policy_info),
                "《隐私政策》",
                "",
                new OnActionListener<Integer>() {
                    @Override
                    public void click(Integer bean) {
                        Toast.makeText(context, "隐私政策", Toast.LENGTH_SHORT).show();
                    }
                });
        tv_content.setText(doubleClickTag);
        tv_content.setMovementMethod(LinkMovementMethod.getInstance());
        builder.setCancelable(false);
        builder.setView(view);
        AlertDialog show = builder.show();
        tv_agree.setOnClickListener(v -> {
            show.dismiss();
            clickListener.onClick(v);
        });
        tv_close_app.setOnClickListener(v -> {
            show.dismiss();
            // 杀死该应用进程 需要权限;
            android.os.Process.killProcess(android.os.Process.myPid());
        });
    }


    /**
     * 给文字中间的 两段文字 设置颜色和点击事件
     *
     * @param colorId 颜色id
     * @param content 主内容
     * @param tag1    第一段文字
     * @param tag2    第二段文字
     */
    public static SpannableString getDoubleClickTag(Context context, int colorId, String content, String tag1, String tag2, OnActionListener<Integer> listener) {
        SpannableString spannableString = new SpannableString(content);
        try {
            int oneStart = content.indexOf(tag1);
            int twoStart = 0;
            int size = 1;
            if (!TextUtils.isEmpty(tag2)) {
                twoStart = content.indexOf(tag2);
                size = 2;
            }

            for (int i = 0; i < size; i++) {
                int integer1;
                int integer2;
                if (i == 0) {
                    integer1 = oneStart;
                    integer2 = oneStart + tag1.length();
                } else {
                    integer1 = twoStart;
                    integer2 = twoStart + tag2.length();
                }
                //设置文字的单击事件
                int finalI = i;
                spannableString.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(@NonNull View widget) {
                        if (listener != null) {
                            listener.click(finalI);
                        }
                    }

                    @Override
                    public void updateDrawState(@NonNull TextPaint ds) {
                        super.updateDrawState(ds);
                        ds.setColor(ContextCompat.getColor(context, colorId));
                        ds.setUnderlineText(false);
                        ds.clearShadowLayer();
                    }
                }, integer1, integer2, Spanned.SPAN_MARK_MARK);
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return spannableString;
    }

    public interface OnActionListener<T> {
        void click(T bean);
    }
}
