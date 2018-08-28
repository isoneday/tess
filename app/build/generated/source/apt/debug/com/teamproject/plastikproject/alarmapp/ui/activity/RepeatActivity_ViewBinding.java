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

public class RepeatActivity_ViewBinding implements Unbinder {
  private RepeatActivity target;

  @UiThread
  public RepeatActivity_ViewBinding(RepeatActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RepeatActivity_ViewBinding(RepeatActivity target, View source) {
    this.target = target;

    target.tvOnce = Utils.findRequiredViewAsType(source, R.id.repeat_once, "field 'tvOnce'", TextView.class);
    target.tvWeekDay = Utils.findRequiredViewAsType(source, R.id.repeat_weekday, "field 'tvWeekDay'", TextView.class);
    target.tvEveryDay = Utils.findRequiredViewAsType(source, R.id.repeat_everyday, "field 'tvEveryDay'", TextView.class);
    target.tvWeekend = Utils.findRequiredViewAsType(source, R.id.repeat_weekend, "field 'tvWeekend'", TextView.class);
    target.tvChoice = Utils.findRequiredViewAsType(source, R.id.repeat_choice, "field 'tvChoice'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RepeatActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvOnce = null;
    target.tvWeekDay = null;
    target.tvEveryDay = null;
    target.tvWeekend = null;
    target.tvChoice = null;
  }
}
