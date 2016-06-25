package toan.android.floatingactionmenu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;

public class AddFloatingActionButton {

    public static Drawable getIconDrawable(Context context) {
        final float iconSize = context.getResources().getDimension(toan.android.floatingactionmenu.R.dimen.fab_icon_size);
        final float iconHalfSize = iconSize / 2f;

        final float plusSize = context.getResources().getDimension(toan.android.floatingactionmenu.R.dimen.fab_plus_icon_size);
        final float plusHalfStroke = context.getResources().getDimension(toan.android.floatingactionmenu.R.dimen.fab_plus_icon_stroke) / 2f;
        final float plusOffset = (iconSize - plusSize) / 2f;

        final Shape shape = new Shape() {
            @Override
            public void draw(Canvas canvas, Paint paint) {
                canvas.drawRect(plusOffset, iconHalfSize - plusHalfStroke, iconSize - plusOffset, iconHalfSize + plusHalfStroke, paint);
                canvas.drawRect(iconHalfSize - plusHalfStroke, plusOffset, iconHalfSize + plusHalfStroke, iconSize - plusOffset, paint);
            }
        };

        ShapeDrawable drawable = new ShapeDrawable(shape);

        final Paint paint = drawable.getPaint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Style.FILL);
        paint.setAntiAlias(true);

        return drawable;
    }
}
