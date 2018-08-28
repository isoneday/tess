// Generated code from Butter Knife. Do not modify!
package com.teamproject.plastikproject.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.teamproject.plastikproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MapFragment_ViewBinding implements Unbinder {
  private MapFragment target;

  private View view2131362595;

  private View view2131362603;

  @UiThread
  public MapFragment_ViewBinding(final MapFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.edtawal, "field 'edtawal' and method 'onViewClicked'");
    target.edtawal = Utils.castView(view, R.id.edtawal, "field 'edtawal'", EditText.class);
    view2131362595 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.edtakhir = Utils.findRequiredViewAsType(source, R.id.edtakhir, "field 'edtakhir'", EditText.class);
    view = Utils.findRequiredView(source, R.id.edtsearch, "field 'edtsearch' and method 'onViewClicked'");
    target.edtsearch = Utils.castView(view, R.id.edtsearch, "field 'edtsearch'", EditText.class);
    view2131362603 = view;
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
    MapFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtawal = null;
    target.edtakhir = null;
    target.edtsearch = null;

    view2131362595.setOnClickListener(null);
    view2131362595 = null;
    view2131362603.setOnClickListener(null);
    view2131362603 = null;
  }
}
