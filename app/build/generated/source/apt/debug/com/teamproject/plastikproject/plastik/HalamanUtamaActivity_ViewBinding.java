// Generated code from Butter Knife. Do not modify!
package com.teamproject.plastikproject.plastik;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.BottomNavigationView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.teamproject.plastikproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HalamanUtamaActivity_ViewBinding implements Unbinder {
  private HalamanUtamaActivity target;

  @UiThread
  public HalamanUtamaActivity_ViewBinding(HalamanUtamaActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HalamanUtamaActivity_ViewBinding(HalamanUtamaActivity target, View source) {
    this.target = target;

    target.mBottomNavigationView = Utils.findRequiredViewAsType(source, R.id.bottom_view, "field 'mBottomNavigationView'", BottomNavigationView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HalamanUtamaActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBottomNavigationView = null;
  }
}
