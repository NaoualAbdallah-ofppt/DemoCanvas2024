package aa.bb.democanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyCanvas extends View {
Context context;
    float posX=0;
    float posY=0;
    public MyCanvas(Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Créer un pinceau et le configurer
        //(couleur, trait, remplissage, dégradé.... )
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(10);
        //Déclarer un rectangle
        Rect r =new Rect(0,100,200,300);
        //Dessiner le rectangle dans le canvas
        canvas.drawRect(r,p);
        //Préparer un autre pinceau
        //avec dégradé
Paint p2 = new Paint();
        p2.setShader( new LinearGradient( 200, 200 ,
                250, 250, Color.BLUE, Color.RED, Shader.TileMode.CLAMP ) );
        //Dessiner un cercle dans la canvas
        canvas.drawCircle(posX,posY,200,p2);

        //On peut ajouter des views (TextViex, Edit Text, linearLayout..)
        //au canvas
        //déclaration dynamique d'un edittext

        EditText edit1 = new EditText(context);
        edit1.setVisibility(View.VISIBLE);
        edit1.setText("Hello world");
        edit1.setTextSize(20);
        //déclaration dynamique d'un layout
        LinearLayout layout = new LinearLayout(context);
        layout.setBackgroundColor(Color.GREEN);
//Ajouter le edittext au layout
        layout.addView(edit1);
        //on a défini la position du layout dans le canvas
        layout.measure(canvas.getWidth(), canvas.getHeight());
        layout.layout(0, 0, canvas.getWidth(), canvas.getHeight());

        canvas.translate(100, 110);
        //on a ajouté la layout créé au canvas
        layout.draw(canvas);






    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
       // Le canvas peut  obéir à des événements
        posX=event.getX();
        posY=event.getY();

        //redraw canvas
        invalidate();
        return super.onTouchEvent(event);

    }
}
