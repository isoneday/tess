// Generated code from Butter Knife. Do not modify!
package com.teamproject.plastikproject.plastik;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.teamproject.plastikproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131363564;

  private View view2131363565;

  private View view2131363569;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    target.regUsername = Utils.findRequiredViewAsType(source, R.id.regUsername, "field 'regUsername'", EditText.class);
    target.regPass = Utils.findRequiredViewAsType(source, R.id.regPass, "field 'regPass'", EditText.class);
    view = Utils.findRequiredView(source, R.id.regBtnLogin, "field 'regBtnLogin' and method 'onViewClicked'");
    target.regBtnLogin = Utils.castView(view, R.id.regBtnLogin, "field 'regBtnLogin'", Button.class);
    view2131363564 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.regBtnRegister, "field 'regBtnRegister' and method 'onViewClicked'");
    target.regBtnRegister = Utils.castView(view, R.id.regBtnRegister, "field 'regBtnRegister'", Button.class);
    view2131363565 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.regforgotpass, "field 'regforgotpass' and method 'onViewClicked'");
    target.regforgotpass = Utils.castView(view, R.id.regforgotpass, "field 'regforgotpass'", Button.class);
    view2131363569 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.regUsername = null;
    target.regPass = null;
    target.regBtnLogin = null;
    target.regBtnRegister = null;
    target.regforgotpass = null;

    view2131363564.setOnClickListener(null);
    view2131363564 = null;
    view2131363565.setOnClickListener(null);
    view2131363565 = null;
    view2131363569.setOnClickListener(null);
    view2131363569 = null;
  }
}
