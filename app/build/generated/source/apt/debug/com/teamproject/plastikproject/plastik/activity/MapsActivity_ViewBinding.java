// Generated code from Butter Knife. Do not modify!
package com.teamproject.plastikproject.plastik.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.teamproject.plastikproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MapsActivity_ViewBinding implements Unbinder {
  private MapsActivity target;

  private View view2131362595;

  private View view2131362594;

  private View view2131362162;

  private View view2131362165;

  @UiThread
  public MapsActivity_ViewBinding(MapsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MapsActivity_ViewBinding(final MapsActivity target, View source) {
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
    view = Utils.findRequiredView(source, R.id.edtakhir, "field 'edtakhir' and method 'onViewClicked'");
    target.edtakhir = Utils.castView(view, R.id.edtakhir, "field 'edtakhir'", EditText.class);
    view2131362594 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.textjarak = Utils.findRequiredViewAsType(source, R.id.textjarak, "field 'textjarak'", TextView.class);
    target.textwaktu = Utils.findRequiredViewAsType(source, R.id.textwaktu, "field 'textwaktu'", TextView.class);
    target.textharga = Utils.findRequiredViewAsType(source, R.id.textharga, "field 'textharga'", TextView.class);
    target.linearLayout = Utils.findRequiredViewAsType(source, R.id.linearLayout, "field 'linearLayout'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.btnlokasiku, "field 'btnlokasiku' and method 'onViewClicked'");
    target.btnlokasiku = Utils.castView(view, R.id.btnlokasiku, "field 'btnlokasiku'", Button.class);
    view2131362162 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btnpanorama, "field 'btnpanorama' and method 'onViewClicked'");
    target.btnpanorama = Utils.castView(view, R.id.btnpanorama, "field 'btnpanorama'", Button.class);
    view2131362165 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.linearbottom = Utils.findRequiredViewAsType(source, R.id.linearbottom, "field 'linearbottom'", LinearLayout.class);
    target.relativemap = Utils.findRequiredViewAsType(source, R.id.relativemap, "field 'relativemap'", RelativeLayout.class);
    target.frame1 = Utils.findRequiredViewAsType(source, R.id.frame1, "field 'frame1'", FrameLayout.class);
    target.spinmode = Utils.findRequiredViewAsType(source, R.id.spinmode, "field 'spinmode'", Spinner.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MapsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtawal = null;
    target.edtakhir = null;
    target.textjarak = null;
    target.textwaktu = null;
    target.textharga = null;
    target.linearLayout = null;
    target.btnlokasiku = null;
    target.btnpanorama = null;
    target.linearbottom = null;
    target.relativemap = null;
    target.frame1 = null;
    target.spinmode = null;

    view2131362595.setOnClickListener(null);
    view2131362595 = null;
    view2131362594.setOnClickListener(null);
    view2131362594 = null;
    view2131362162.setOnClickListener(null);
    view2131362162 = null;
    view2131362165.setOnClickListener(null);
    view2131362165 = null;
  }
}
