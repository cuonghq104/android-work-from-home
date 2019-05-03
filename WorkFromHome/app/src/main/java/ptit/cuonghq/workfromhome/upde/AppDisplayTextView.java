package ptit.cuonghq.workfromhome.upde;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import ptit.cuonghq.workfromhome.R;

public class AppDisplayTextView extends LinearLayout {

    public AppDisplayTextView(Context context) {
        this(context, null);
    }

    public AppDisplayTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.app_display_textview, this, true);
        AppCompatTextView mTvTitle = view.findViewById(R.id.tv_title);
        AppCompatTextView mTvContent = view.findViewById(R.id.tv_content);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AppDisplayTextView, 0, 0);
        String title = typedArray.getString(R.styleable.AppDisplayTextView_displayTitle);
        String content = typedArray.getString(R.styleable.AppDisplayTextView_displayContent);
        mTvTitle.setText(title);
        mTvContent.setText(content);
        typedArray.recycle();
    }

}
