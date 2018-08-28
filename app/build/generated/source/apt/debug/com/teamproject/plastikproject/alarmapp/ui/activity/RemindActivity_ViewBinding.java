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

public class RemindActivity_ViewBinding implements Unbinder {
  private RemindActivity target;

  @UiThread
  public RemindActivity_ViewBinding(RemindActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RemindActivity_ViewBinding(RemindActivity target, View source) {
    this.target = target;

    target.tv_remind_three = Utils.findRequiredViewAsType(source, R.id.remind_three, "field 'tv_remind_three'", TextView.class);
    target.tv_remind_five = Utils.findRequiredViewAsType(source, R.id.remind_five, "field 'tv_remind_five'", TextView.class);
    target.tv_remind_ten = Utils.findRequiredViewAsType(source, R.id.remind_ten, "field 'tv_remind_ten'", TextView.class);
    target.tv_remind_twenty = Utils.findRequiredViewAsType(source, R.id.remind_twenty, "field 'tv_remind_twenty'", TextView.class);
    target.tv_remind_half_hour = Utils.findRequiredViewAsType(source, R.id.remind_half_hour, "field 'tv_remind_half_hour'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RemindActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_remind_three = null;
    target.tv_remind_five = null;
    target.tv_remind_ten = null;
    target.tv_remind_twenty = null;
    target.tv_remind_half_hour = null;
  }
}
