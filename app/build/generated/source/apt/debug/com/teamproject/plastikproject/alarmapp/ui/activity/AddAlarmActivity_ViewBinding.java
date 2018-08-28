// Generated code from Butter Knife. Do not modify!
package com.teamproject.plastikproject.alarmapp.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.teamproject.plastikproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddAlarmActivity_ViewBinding implements Unbinder {
  private AddAlarmActivity target;

  private View view2131361896;

  private View view2131362738;

  @UiThread
  public AddAlarmActivity_ViewBinding(AddAlarmActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddAlarmActivity_ViewBinding(final AddAlarmActivity target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.cvRepeat = Utils.findRequiredViewAsType(source, R.id.alarm_cv_repeat, "field 'cvRepeat'", CardView.class);
    target.tvRepeat = Utils.findRequiredViewAsType(source, R.id.repeat_content, "field 'tvRepeat'", TextView.class);
    target.cvRing = Utils.findRequiredViewAsType(source, R.id.alarm_cv_ring, "field 'cvRing'", CardView.class);
    target.tvRingtones = Utils.findRequiredViewAsType(source, R.id.ringtones_content, "field 'tvRingtones'", TextView.class);
    target.cvRemind = Utils.findRequiredViewAsType(source, R.id.alarm_cv_remind, "field 'cvRemind'", CardView.class);
    target.tvRemind = Utils.findRequiredViewAsType(source, R.id.remind_content, "field 'tvRemind'", TextView.class);
    target.switchVibration = Utils.findRequiredViewAsType(source, R.id.switch_vibration, "field 'switchVibration'", SwitchCompat.class);
    target.switchWeather = Utils.findRequiredViewAsType(source, R.id.switch_weather, "field 'switchWeather'", SwitchCompat.class);
    target.edtdesc = Utils.findRequiredViewAsType(source, R.id.edtdesc, "field 'edtdesc'", EditText.class);
    target.txtday = Utils.findRequiredViewAsType(source, R.id.txtday, "field 'txtday'", TextView.class);
    target.txtselectday = Utils.findRequiredViewAsType(source, R.id.txtselectday, "field 'txtselectday'", TextView.class);
    target.cvdayform = Utils.findRequiredViewAsType(source, R.id.dayform, "field 'cvdayform'", CardView.class);
    view = Utils.findRequiredView(source, R.id.alarm_cv_time, "method 'OnTimeClick'");
    view2131361896 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnTimeClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.floating_action_btn2, "method 'OnFAB2Click'");
    view2131362738 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnFAB2Click();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AddAlarmActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.toolbarTitle = null;
    target.cvRepeat = null;
    target.tvRepeat = null;
    target.cvRing = null;
    target.tvRingtones = null;
    target.cvRemind = null;
    target.tvRemind = null;
    target.switchVibration = null;
    target.switchWeather = null;
    target.edtdesc = null;
    target.txtday = null;
    target.txtselectday = null;
    target.cvdayform = null;

    view2131361896.setOnClickListener(null);
    view2131361896 = null;
    view2131362738.setOnClickListener(null);
    view2131362738 = null;
  }
}
