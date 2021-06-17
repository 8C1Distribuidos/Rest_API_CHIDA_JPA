package com.weine.tools;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Formatter {
    public static final Gson deserializerGson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                        throws JsonParseException {
                    return LocalDateTime.parse(json.getAsString(),
                            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss").withLocale(Locale.ENGLISH));
                }
            })
            .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                        throws JsonParseException {
                    return LocalDate.parse(json.getAsString(),
                            DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH));
                }
            })
            .create();
    public static final Gson serializergson = new GsonBuilder().create();

    public static <D> List<D> getList(String object, Class<D[]> classType){
        D[] arrays = deserializerGson.fromJson(object, classType);
        return new ArrayList<D>(Arrays.asList(arrays));
    }
    public static <D> D getObject(String object, Class<D> classType){
        return deserializerGson.fromJson(object, classType);
    }
}
