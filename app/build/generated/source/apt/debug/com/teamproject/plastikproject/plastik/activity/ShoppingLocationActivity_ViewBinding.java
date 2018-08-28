// Generated code from Butter Knife. Do not modify!
package com.teamproject.plastikproject.plastik.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.teamproject.plastikproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ShoppingLocationActivity_ViewBinding implements Unbinder {
  private ShoppingLocationActivity target;

  private View view2131363139;

  private View view2131363140;

  private View view2131363607;

  @UiThread
  public ShoppingLocationActivity_ViewBinding(ShoppingLocationActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ShoppingLocationActivity_ViewBinding(final ShoppingLocationActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lokasiawal, "field 'lokasiawal' and method 'onViewClicked'");
    target.lokasiawal = Utils.castView(view, R.id.lokasiawal, "field 'lokasiawal'", TextView.class);
    view2131363139 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lokasitujuan, "field 'lokasitujuan' and method 'onViewClicked'");
    target.lokasitujuan = Utils.castView(view, R.id.lokasitujuan, "field 'lokasitujuan'", TextView.class);
    view2131363140 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.requestorder, "field 'requestorder' and method 'onViewClicked'");
    target.requestorder = Utils.castView(view, R.id.requestorder, "field 'requestorder'", Button.class);
    view2131363607 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.txtharga = Utils.findRequiredViewAsType(source, R.id.txtjenissos, "field 'txtharga'", TextView.class);
    target.catatan = Utils.findRequiredViewAsType(source, R.id.tujuan, "field 'catatan'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ShoppingLocationActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lokasiawal = null;
    target.lokasitujuan = null;
    target.requestorder = null;
    target.txtharga = null;
    target.catatan = null;

    view2131363139.setOnClickListener(null);
    view2131363139 = null;
    view2131363140.setOnClickListener(null);
    view2131363140 = null;
    view2131363607.setOnClickListener(null);
    view2131363607 = null;
  }
}
