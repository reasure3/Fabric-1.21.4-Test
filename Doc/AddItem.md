# 아이템 추가

## [공식 위키 보기](https://docs.fabricmc.net/develop/items/first-item)

## 코드
[ModItems.java](../src/main/java/com/reasure/test/item/ModItems.java)
```java
public class ModItems {
    public static final Item SUSPICIOUS_SUBSTANCE = registerSimpleItem("suspicious_substance", new Item.Settings());
    
    public static Item registerSimpleItem(String name, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Test.MOD_ID, name));
        Item item = new Item(settings.registerKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public static void initialize() {}
}
```
(메인 모드 파일)
[Test.java](../src/main/java/com/reasure/test/Test.java)
```java
public class Test implements ModInitializer {
    public static final String MOD_ID = "test";

    @Override
    public void onInitialize() {
        ModItems.initialize();
    }
}
```

## 텍스쳐파일
<img src="../src/main/resources/assets/test/textures/item/suspicious_substance.png" height="64"><br>
[assets/test/textures/item/suspicious_substance.png](../src/main/resources/assets/test/textures/item/suspicious_substance.png)

## 아이템 모델 파일
[assets/test/models/item/suspicious_substance.json](../src/main/resources/assets/test/models/item/suspicious_substance.json)
```json
{
  "parent": "item/generated",
  "textures": {
    "layer0": "test:item/suspicious_substance"
  }
}
```
- 설명<br>
  `"test:item/suspicious_substance"` 부분은 [텍스쳐 파일](../src/main/resources/assets/test/textures/item/suspicious_substance.png) 경로를 의미함.

## 아이템 모델 정의 파일
[assets/test/items/suspicious_substance.json](../src/main/resources/assets/test/items/suspicious_substance.json)
```json
{
  "model": {
    "type": "minecraft:model",
    "model": "test:item/suspicious_substance"
  }
}
```
- 설명<br>
  어떤 조건에 어떤 모델을 사용할지 정의하는 파일<br>
  위 코드는 가장 단순한 형태로, 항상 suspicious_substance 모델을 사용함을 의미<br>
  `"test:item/suspicious_substance"` 부분은 [모델 파일](../src/main/resources/assets/test/models/item/suspicious_substance.json) 경로를 의미함.

## lang 파일
[assets/test/lang/en_us.json](../src/main/resources/assets/test/lang/en_us.json)
```json
{
  "item.test.suspicious_substance": "Suspicious Substance"
}
```
