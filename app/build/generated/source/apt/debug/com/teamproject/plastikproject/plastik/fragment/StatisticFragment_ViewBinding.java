// Generated code from Butter Knife. Do not modify!
package com.teamproject.plastikproject.plastik.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.teamproject.plastikproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StatisticFragment_ViewBinding implements Unbinder {
  private StatisticFragment target;

  @UiThread
  public StatisticFragment_ViewBinding(StatisticFragment target, View source) {
    this.target = target;

    target.webstatistic = Utils.findRequiredViewAsType(source, R.id.webstatistic, "field 'webstatistic'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StatisticFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.webstatistic = null;
  }
}
