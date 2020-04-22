package minestrapp;

import net.minecraft.client.renderer.RenderType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface RenderLayer {

    Type type();

    enum Type{
        CUTOUT_MIPPED(RenderType.getCutoutMipped()),
        CUTOUT(RenderType.getCutout()),
        TRANSLUCENT(RenderType.getTranslucent());

        RenderType renderType;

        Type(RenderType renderType){
            this.renderType = renderType;
        }

        public RenderType gerRenderType(){
            return renderType;
        }
    }

}
