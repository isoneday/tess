// Generated code from Butter Knife. Do not modify!
package com.teamproject.plastikproject.plastik.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.teamproject.plastikproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyAccountFragment_ViewBinding implements Unbinder {
  private MyAccountFragment target;

  @UiThread
  public MyAccountFragment_ViewBinding(MyAccountFragment target, View source) {
    this.target = target;

    target.txtusername = Utils.findRequiredViewAsType(source, R.id.txtusername, "field 'txtusername'", TextView.class);
    target.btnchangeusername = Utils.findRequiredViewAsType(source, R.id.btnchangeusername, "field 'btnchangeusername'", Button.class);
    target.txtnama = Utils.findRequiredViewAsType(source, R.id.txtnama, "field 'txtnama'", TextView.class);
    target.txtemail = Utils.findRequiredViewAsType(source, R.id.txtemail, "field 'txtemail'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyAccountFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtusername = null;
    target.btnchangeusername = null;
    target.txtnama = null;
    target.txtemail = null;
  }
}
