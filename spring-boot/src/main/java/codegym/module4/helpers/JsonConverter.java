package codegym.module4.helpers;

public class JsonConverter
{
    private StringBuilder stringBuilder;
    private boolean existsProp;

    public JsonConverter(){
        stringBuilder=new StringBuilder();
        stringBuilder.append("{");
        existsProp =false;
    }

    public JsonConverter addProperty(String name,Object value){
        if(existsProp){
            stringBuilder.append(",");
        }
        stringBuilder
                .append("\"").append(name).append("\"").append(":")
                .append("\"").append(value).append("\"");
        existsProp=true;
        return this;
    }

    public String getJsonObject(){
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
