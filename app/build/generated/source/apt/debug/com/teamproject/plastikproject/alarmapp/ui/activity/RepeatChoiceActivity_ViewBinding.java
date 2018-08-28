// Generated code from Butter Knife. Do not modify!
package com.teamproject.plastikproject.alarmapp.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.teamproject.plastikproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RepeatChoiceActivity_ViewBinding implements Unbinder {
  private RepeatChoiceActivity target;

  @UiThread
  public RepeatChoiceActivity_ViewBinding(RepeatChoiceActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RepeatChoiceActivity_ViewBinding(RepeatChoiceActivity target, View source) {
    this.target = target;

    target.tvSun = Utils.findRequiredViewAsType(source, R.id.repeat_sun, "field 'tvSun'", TextView.class);
    target.tvMon = Utils.findRequiredViewAsType(source, R.id.repeat_mon, "field 'tvMon'", TextView.class);
    target.tvTue = Utils.findRequiredViewAsType(source, R.id.repeat_tue, "field 'tvTue'", TextView.class);
    target.tvWed = Utils.findRequiredViewAsType(source, R.id.repeat_wed, "field 'tvWed'", TextView.class);
    target.tvThu = Utils.findRequiredViewAsType(source, R.id.repeat_thu, "field 'tvThu'", TextView.class);
    target.tvFri = Utils.findRequiredViewAsType(source, R.id.repeat_fri, "field 'tvFri'", TextView.class);
    target.tvSat = Utils.findRequiredViewAsType(source, R.id.repeat_sat, "field 'tvSat'", TextView.class);
    target.tvCancel = Utils.findRequiredViewAsType(source, R.id.repeat_cancel, "field 'tvCancel'", TextView.class);
    target.tvOk = Utils.findRequiredViewAsType(source, R.id.repeat_ok, "field 'tvOk'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RepeatChoiceActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvSun = null;
    target.tvMon = null;
    target.tvTue = null;
    target.tvWed = null;
    target.tvThu = null;
    target.tvFri = null;
    target.tvSat = null;
    target.tvCancel = null;
    target.tvOk = null;
  }
}
