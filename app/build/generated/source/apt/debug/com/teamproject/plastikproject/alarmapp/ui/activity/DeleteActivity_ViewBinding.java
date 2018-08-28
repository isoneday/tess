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

public class DeleteActivity_ViewBinding implements Unbinder {
  private DeleteActivity target;

  @UiThread
  public DeleteActivity_ViewBinding(DeleteActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DeleteActivity_ViewBinding(DeleteActivity target, View source) {
    this.target = target;

    target.tvCancel = Utils.findRequiredViewAsType(source, R.id.delete_cancel, "field 'tvCancel'", TextView.class);
    target.tvOk = Utils.findRequiredViewAsType(source, R.id.delete_ok, "field 'tvOk'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DeleteActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvCancel = null;
    target.tvOk = null;
  }
}
