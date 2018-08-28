// Generated code from Butter Knife. Do not modify!
package com.teamproject.plastikproject.alarmapp.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.teamproject.plastikproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RingActivity_ViewBinding implements Unbinder {
  private RingActivity target;

  @UiThread
  public RingActivity_ViewBinding(RingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RingActivity_ViewBinding(RingActivity target, View source) {
    this.target = target;

    target.rv_ringList = Utils.findRequiredViewAsType(source, R.id.ring_list, "field 'rv_ringList'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv_ringList = null;
  }
}
