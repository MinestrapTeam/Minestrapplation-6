package minestrapp.utils;

import minestrapp.Minestrapp;
import minestrapp.RenderLayer;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

public class Reflection {

    public static void findRenderTypes(){
        Minestrapp.logger.info("Scanning for Render annotation");

        Reflections reflection = new Reflections("minestrapp", new FieldAnnotationsScanner());

        Set<Field> allClasses = reflection.getFieldsAnnotatedWith(RenderLayer.class);

        for(Field c : allClasses){
            Annotation[] annotations = c.getAnnotations();

            for(Annotation annotation : annotations){

                if(annotation instanceof RenderLayer){
                    RenderLayer renderType = (RenderLayer) annotation;
                    System.out.println("Found RenderType in " + c.getName() + " value: " + renderType.type());
                }
            }
        }

    }
}
