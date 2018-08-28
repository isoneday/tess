// Generated code from Butter Knife. Do not modify!
package com.teamproject.plastikproject.alarmapp.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.teamproject.plastikproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import net.steamcrafted.materialiconlib.MaterialIconView;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131362737;

  private View view2131362971;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.cLayout = Utils.findRequiredViewAsType(source, R.id.clayout, "field 'cLayout'", CoordinatorLayout.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.add_alarmlist, "field 'recyclerView'", RecyclerView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.weatherIcon = Utils.findRequiredViewAsType(source, R.id.image_weather_icon, "field 'weatherIcon'", MaterialIconView.class);
    target.tvLocation = Utils.findRequiredViewAsType(source, R.id.tv_location, "field 'tvLocation'", TextView.class);
    target.tvCondition = Utils.findRequiredViewAsType(source, R.id.tv_condition, "field 'tvCondition'", TextView.class);
    target.tvTemp = Utils.findRequiredViewAsType(source, R.id.tv_temp, "field 'tvTemp'", TextView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_weather_title, "field 'tvTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.floating_action_btn, "method 'OnFABClick'");
    view2131362737 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnFABClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.ib_refresh, "method 'OnRefresh'");
    view2131362971 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnRefresh();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.cLayout = null;
    target.recyclerView = null;
    target.toolbar = null;
    target.weatherIcon = null;
    target.tvLocation = null;
    target.tvCondition = null;
    target.tvTemp = null;
    target.tvTitle = null;

    view2131362737.setOnClickListener(null);
    view2131362737 = null;
    view2131362971.setOnClickListener(null);
    view2131362971 = null;
  }
}
