package rowley.androidstyleableviewexample.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import rowley.androidstyleableviewexample.R;

/**
 * This view combines several elements, including a primary EditText, an error or label Textview
 * and a stateful highlight bar
 */
public class ComplexEditText extends RelativeLayout {

    @Bind(R.id.complex_edit_text_status_bar)
    View highLightBar;
    @Bind(R.id.supplemental_text_view)
    TextView label;
    @Bind(R.id.input)
    EditText input;

    public ComplexEditText(Context context) {
        super(context);
        initView(context, null);
    }

    public ComplexEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public ComplexEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        inflate(context, R.layout.complex_edit_text, this);
        ButterKnife.bind(this);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ComplexEditText);
        for(int i = 0; i < typedArray.getIndexCount(); i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.ComplexEditText_rootBackground:
                    try {
                        int color = typedArray.getColor(attr, -1);
                        if(color != -1) {
                            setBackgroundColor(color);
                        }
                    } catch (UnsupportedOperationException e) {
                        e.printStackTrace();
                        try {
                            Drawable drawable = typedArray.getDrawable(attr);
                            if(drawable != null) {
                                setBackgroundDrawable(drawable);
                            }
                        } catch (UnsupportedOperationException e1) {
                            e1.printStackTrace();
                        }
                    }
                    break;
                case R.styleable.ComplexEditText_highLighBarBackground:
                    try {
                        int color = typedArray.getColor(attr, -1);
                        if(color != -1) {
                            highLightBar.setBackgroundColor(color);
                        }
                    } catch (UnsupportedOperationException e) {
                        e.printStackTrace();
                        try {
                            Drawable drawable = typedArray.getDrawable(attr);
                            if(drawable != null) {
                                highLightBar.setBackgroundDrawable(drawable);
                            }
                        } catch (UnsupportedOperationException e1) {
                            e1.printStackTrace();
                        }
                    }
                    break;
                case R.styleable.ComplexEditText_labelText:
                    label.setText(typedArray.getText(attr));
                    break;
                case R.styleable.ComplexEditText_labelTextColor:
                    label.setTextColor(typedArray.getColorStateList(attr));
                    break;
                case R.styleable.ComplexEditText_labelTextSize:
                    label.setTextSize(typedArray.getDimensionPixelSize(attr, (int)label.getTextSize()));
                    break;
                case R.styleable.ComplexEditText_inputHintText:
                    input.setHint(typedArray.getText(attr));
                    break;
                case R.styleable.ComplexEditText_inputHintColor:
                    input.setHintTextColor(typedArray.getColorStateList(attr));
                    break;
                case R.styleable.ComplexEditText_inputTextSize:
                    input.setTextSize(typedArray.getDimensionPixelSize(attr, (int)input.getTextSize()));
                    break;
                case R.styleable.ComplexEditText_inputTextColor:
                    input.setTextColor(typedArray.getColorStateList(attr));
            }
        }
        typedArray.recycle();
    }
}
