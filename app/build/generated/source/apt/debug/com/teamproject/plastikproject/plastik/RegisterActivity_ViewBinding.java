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

public class RegisterActivity_ViewBinding implements Unbinder {
  private RegisterActivity target;

  private View view2131362166;

  private View view2131362161;

  @UiThread
  public RegisterActivity_ViewBinding(RegisterActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RegisterActivity_ViewBinding(final RegisterActivity target, View source) {
    this.target = target;

    View view;
    target.edtnama = Utils.findRequiredViewAsType(source, R.id.edtnama, "field 'edtnama'", EditText.class);
    target.edtemail = Utils.findRequiredViewAsType(source, R.id.edtemail, "field 'edtemail'", EditText.class);
    target.edtpassword = Utils.findRequiredViewAsType(source, R.id.edtpassword, "field 'edtpassword'", EditText.class);
    target.edtpasswordconfirm = Utils.findRequiredViewAsType(source, R.id.edtpasswordconfirm, "field 'edtpasswordconfirm'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btnregister, "field 'btnregister' and method 'onViewClicked'");
    target.btnregister = Utils.castView(view, R.id.btnregister, "field 'btnregister'", Button.class);
    view2131362166 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btnlogin, "method 'onViewClicked'");
    view2131362161 = view;
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
    RegisterActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtnama = null;
    target.edtemail = null;
    target.edtpassword = null;
    target.edtpasswordconfirm = null;
    target.btnregister = null;

    view2131362166.setOnClickListener(null);
    view2131362166 = null;
    view2131362161.setOnClickListener(null);
    view2131362161 = null;
  }
}
