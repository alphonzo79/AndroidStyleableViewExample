package rowley.androidstyleableviewexample.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
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
public class ComplexEditText extends RelativeLayout implements View.OnFocusChangeListener {

    @Bind(R.id.complex_edit_text_status_bar)
    View highLightBar;
    @Bind(R.id.supplemental_text_view)
    TextView label;
    @Bind(R.id.input)
    EditText input;

    private boolean enabled = true;

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
                    break;
                case R.styleable.ComplexEditText_enabled:
                    setEnabled(typedArray.getBoolean(attr, enabled));
            }
        }
        typedArray.recycle();

        input.setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View view, boolean focused) {
        highLightBar.setActivated(focused);
    }

    /**
     * Set the enabled state of the root layout, which is duplicated by the highlight bar
     * @param enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Set the given color int to the highlight bar background
     * @param color
     */
    public void setHighLightBarBackground(@ColorInt int color) {
        highLightBar.setBackgroundColor(color);
    }

    /**
     * Set the drawable referenced by the given resource to the highlight bar background
     * @param drawableResource
     */
    public void setHighLightBarBackgroundResource(@DrawableRes int drawableResource) {
        highLightBar.setBackgroundResource(drawableResource);
    }

    /**
     * Set the given drawable to the highlight bar background
     * @param drawable
     */
    public void setHighlightBarBackground(Drawable drawable) {
        highLightBar.setBackgroundDrawable(drawable);
    }

    /**
     * Set the label text
     * @param text
     */
    public void setLabelText(CharSequence text) {
        label.setText(text);
    }

    /**
     * Set the label text
     * @param text
     */
    public void setLabelText(@StringRes  int text) {
        label.setText(text);
    }

    /**
     * Set the text color on the label
     * @param color
     */
    public void setLabelTextColor(@ColorInt int color) {
        label.setTextColor(color);
    }

    /**
     * Set the text color on the label
     * @param colorStateList
     */
    public void setLabelTextColor(ColorStateList colorStateList) {
        label.setTextColor(colorStateList);
    }

    /**
     * Set the text size for the label
     * @param textSize
     */
    public void setLabelTextSize(float textSize) {
        label.setTextSize(textSize);
    }

    /**
     * Set the hint text for the input
     * @param hintText
     */
    public void setInputHintText(CharSequence hintText) {
        input.setHint(hintText);
    }

    /**
     * Set the hint text for the input
     * @param hintText
     */
    public void setInputHintText(@StringRes int hintText) {
        input.setHint(hintText);
    }

    /**
     * Set the hint text color for the input
     * @param color
     */
    public void setInputHintTextColor(@ColorInt int color) {
        input.setHintTextColor(color);
    }

    /**
     * Set the hint text color for the input
     * @param colorStateList
     */
    public void setInputHintTextColor(ColorStateList colorStateList) {
        input.setHintTextColor(colorStateList);
    }

    /**
     * Set the text size for the input
     * @param textSize
     */
    public void setInputTextSize(float textSize) {
        input.setTextSize(textSize);
    }

    /**
     * Set the text color for the input
     * @param color
     */
    public void setInputTextColor(@ColorInt int color) {
        input.setTextColor(color);
    }

    /**
     * Set the text color for the input
     * @param colorStateList
     */
    public void setInputTextColor(ColorStateList colorStateList) {
        input.setTextColor(colorStateList);
    }
}
