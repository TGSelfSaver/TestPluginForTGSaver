# Как создать плагин? (TGSaver >= 2.0.Beta-8)
1) Создайте Java проект
2) Импортируйте Jar файл TGSaver в ваш проект как библиотеку.
3) Создайте и заполните конфигурационный файл по пути: ```src/main/resources/Config.ysc```
```yscript
plugin.versions.name = "1.0"
plugin.versions.code = "1"
plugin.name = "MyPlugin"
plugin.description = "Sample Plugin"
plugin.class = "ru.yoricya.TGSaver.plugins.TestPlugin.TestPlugin"
versions.target = "8"
versions.max = "-1"
```
* Где:
* `plugin.class = "ru.yoricya.TGSaver.plugins.TestPlugin.TestPlugin"` - путь до вашего  "main" класса
* `versions.target = "8"` - Минимально совместимая версия TGSaver
* `versions.max = "-1"` - Максимально совместимая версия TGSaver (`-1` - без ограничения)

4) Вставьте в ваш Main класс следующий код:
```java
public class TestPlugin extends PluginLoader.Plugin {
    @Override
    public void execute(PluginAPI api){

    }
}
```
* `execute(PluginAPI api)` - Основная функция к которой TGSaver обращается при загрузке плагина, сюда вставьте ваш код.
5) Готово! Скомпилируйте плагин, и вставьте его в папку `plugins/` вашего TGSaver(-a)!

# Как создать плагин? (TGSaver < 2.0.Beta-8)
1) Создайте Java проект
2) Импортируйте Jar файл TGSaver в ваш проект как библиотеку.
3) Создайте и вставьте в файл по пути: ```src/main/resources/Config.ysc``` следующие строчки:
```yscript
class = "ru.yoricya.TGSaver.plugins.TestPlugin.TestPlugin"
```
* Где: `"ru.yoricya.TGSaver.plugins.TestPlugin.TestPlugin"` - путь до вашего  "main" класса

4) Вставьте в ваш Main класс следующий код:
```java
public class TestPlugin implements PluginLoader.Plugin {
    @Override
    public void execute(PluginAPI api){

    }
    @Override
    public PluginLoader.PluginInfo pluginInfo(){
        return new PluginLoader.PluginInfo("TestPlugin", "Sample Plugin", 1, "Version 1.0");
    }
}
```
* `execute(PluginAPI api)` - Основная функция к которой TGSaver обращается при загрузке плагина, сюда вставьте ваш код.
* `pluginInfo()` - Самая первая функция к которой обращается TGSaver, в ней задаются такие параметры как: Имя плагина, Описание плагина, Код Версии и Версия плагина
5) Готово! Скомпилируйте плагин, и вставьте его в папку `plugins/` вашего TGSaver(-a)!
