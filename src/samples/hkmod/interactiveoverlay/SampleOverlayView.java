package samples.hkmod.interactiveoverlay;

/*
Copyright 2011 jawsware international

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/


import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.TextView;

import android.os.Bundle;
import android.app.Activity;
// import android.os.Bundle;
import library.src.net.hkmod.menudrawer.MenuDrawer;
import library.src.net.hkmod.menudrawer.Position;


import com.hkmod.core.share.OverlayService;
import com.hkmod.core.share.OverlayView;

public class SampleOverlayView extends OverlayView {

	private TextView info;
	
    private MenuDrawer mMenuDrawer;
    private TextView mContentTextView;
	
	
	public SampleOverlayView(OverlayService service) {
		
		super(service, R.layout.overlay, 1);
		
	}

	public int getGravity() {
		return Gravity.TOP + Gravity.RIGHT;
	}
	
	@Override
	protected void onInflateView() {
		info = (TextView) this.findViewById(R.id.textview_info);
	}

	@Override
	protected void refreshViews() {
		info.setText("WAITING\nWAITING");
	}

	@Override
	protected void onTouchEvent_Up(MotionEvent event) {
		info.setText("UP\nPOINTERS: " + event.getPointerCount());
	}

	@Override
	protected void onTouchEvent_Move(MotionEvent event) {
		info.setText("MOVE\nPOINTERS: " + event.getPointerCount());
	}

	@Override
	protected void onTouchEvent_Press(MotionEvent event) {
		info.setText("DOWN\nPOINTERS: " + event.getPointerCount());
	}

	@Override
	public boolean onTouchEvent_LongPress() {
		info.setText("LONG\nPRESS");

		return true;
	}
	
	
}
