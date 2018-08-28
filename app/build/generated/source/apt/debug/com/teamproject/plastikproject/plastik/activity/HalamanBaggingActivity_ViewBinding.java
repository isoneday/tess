// Generated code from Butter Knife. Do not modify!
package com.teamproject.plastikproject.plastik.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.BottomNavigationView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.teamproject.plastikproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HalamanBaggingActivity_ViewBinding implements Unbinder {
  private HalamanBaggingActivity target;

  @UiThread
  public HalamanBaggingActivity_ViewBinding(HalamanBaggingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HalamanBaggingActivity_ViewBinding(HalamanBaggingActivity target, View source) {
    this.target = target;

    target.bottomView = Utils.findRequiredViewAsType(source, R.id.bottom_view, "field 'bottomView'", BottomNavigationView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HalamanBaggingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.bottomView = null;
  }
}
