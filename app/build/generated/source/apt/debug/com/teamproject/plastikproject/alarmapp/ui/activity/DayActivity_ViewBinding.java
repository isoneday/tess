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

public class DayActivity_ViewBinding implements Unbinder {
  private DayActivity target;

  @UiThread
  public DayActivity_ViewBinding(DayActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DayActivity_ViewBinding(DayActivity target, View source) {
    this.target = target;

    target.monday = Utils.findRequiredViewAsType(source, R.id.monday, "field 'monday'", TextView.class);
    target.tuesday = Utils.findRequiredViewAsType(source, R.id.tuesday, "field 'tuesday'", TextView.class);
    target.wednesday = Utils.findRequiredViewAsType(source, R.id.wednesday, "field 'wednesday'", TextView.class);
    target.thursday = Utils.findRequiredViewAsType(source, R.id.thursday, "field 'thursday'", TextView.class);
    target.friday = Utils.findRequiredViewAsType(source, R.id.friday, "field 'friday'", TextView.class);
    target.saturday = Utils.findRequiredViewAsType(source, R.id.saturday, "field 'saturday'", TextView.class);
    target.sunday = Utils.findRequiredViewAsType(source, R.id.sunday, "field 'sunday'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DayActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.monday = null;
    target.tuesday = null;
    target.wednesday = null;
    target.thursday = null;
    target.friday = null;
    target.saturday = null;
    target.sunday = null;
  }
}
