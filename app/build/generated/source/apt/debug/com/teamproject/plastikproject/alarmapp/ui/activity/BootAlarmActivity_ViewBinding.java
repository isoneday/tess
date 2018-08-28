// Generated code from Butter Knife. Do not modify!
package com.teamproject.plastikproject.alarmapp.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.teamproject.plastikproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import net.steamcrafted.materialiconlib.MaterialIconView;

public class BootAlarmActivity_ViewBinding implements Unbinder {
  private BootAlarmActivity target;

  @UiThread
  public BootAlarmActivity_ViewBinding(BootAlarmActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BootAlarmActivity_ViewBinding(BootAlarmActivity target, View source) {
    this.target = target;

    target.weatherIcon = Utils.findRequiredViewAsType(source, R.id.weather_icon, "field 'weatherIcon'", MaterialIconView.class);
    target.wifiIcon = Utils.findRequiredViewAsType(source, R.id.wifi_icon, "field 'wifiIcon'", MaterialIconView.class);
    target.tvLocation = Utils.findRequiredViewAsType(source, R.id.tv_location, "field 'tvLocation'", TextView.class);
    target.tvCondition = Utils.findRequiredViewAsType(source, R.id.tv_condition, "field 'tvCondition'", TextView.class);
    target.tvTemp = Utils.findRequiredViewAsType(source, R.id.tv_temp, "field 'tvTemp'", TextView.class);
    target.rvAlarmOff = Utils.findRequiredViewAsType(source, R.id.rl_boot_alarm_off, "field 'rvAlarmOff'", RelativeLayout.class);
    target.rvPutOff = Utils.findRequiredViewAsType(source, R.id.rl_boot_put_off, "field 'rvPutOff'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BootAlarmActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.weatherIcon = null;
    target.wifiIcon = null;
    target.tvLocation = null;
    target.tvCondition = null;
    target.tvTemp = null;
    target.rvAlarmOff = null;
    target.rvPutOff = null;
  }
}
