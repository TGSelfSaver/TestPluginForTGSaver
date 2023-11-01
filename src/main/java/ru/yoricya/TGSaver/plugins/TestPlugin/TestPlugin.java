package ru.yoricya.TGSaver.plugins.TestPlugin;

import it.tdlight.jni.TdApi;
import ru.yoricya.tgauto.Main;
import ru.yoricya.tgauto.PluginAPI;
import ru.yoricya.tgauto.PluginLoader;

import static ru.yoricya.tgauto.PluginAPI.Event.MESSAGE_TEXT_EVENT;

public class TestPlugin implements PluginLoader.Plugin {
    PluginAPI.EventListener el = null;
    PluginAPI api;
    @Override
    public void execute(PluginAPI api){
        this.api = api;
        el = new PluginAPI.EventListener() {
            @Override
            public PluginAPI.Event onEvent(PluginAPI.Event event) {
                if(event.EventType == MESSAGE_TEXT_EVENT && event.EventData != null){
                    String txt = ((TdApi.MessageText) event.EventData).text.text;
                    api.getLogger().info("Новое сообщение:"+txt);
                }
                return event;
            }
        };
        api.registerEventHandler(this, el);
    }
    @Override
    public PluginLoader.PluginInfo pluginInfo(){
        return new PluginLoader.PluginInfo("TestPlugin", "Sample Plugin", 1, "Version 1.0");
    }
}
