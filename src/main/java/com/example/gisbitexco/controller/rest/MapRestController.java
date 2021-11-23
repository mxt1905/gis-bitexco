package com.example.gisbitexco.controller.rest;

import com.example.gisbitexco.constants.ArcgisConst.Attribute.Building;
import com.example.gisbitexco.constants.ArcgisConst.Attribute.Graphic;
import com.example.gisbitexco.constants.ArcgisConst.Value;
import com.example.gisbitexco.dto.BodyDto;
import com.example.gisbitexco.dto.FaceDto;
import com.example.gisbitexco.service.BodyService;
import com.example.gisbitexco.service.FaceService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * MapRestController
 */
@RestController
@RequiredArgsConstructor
public class MapRestController {

    private final FaceService faceService;
    private final BodyService bodyService;
    private static final String BUILDING_DESCRIPTION = "Tòa Hành Chính Bitexco Financial";

    @GetMapping("/api/bitexco_json")
    @SuppressWarnings("unchecked")
    public List<JSONObject> getBitexco9() throws ParseException {
        List<JSONObject> jsonList = new ArrayList<>();

        for (int i = 1; i <= 46; i++) {
            JSONObject json = new JSONObject();
            List<JSONArray> list = new ArrayList<>();
            FaceDto faceDto = faceService.searchById(i);
            faceDto.getNodes().forEach(nodeDto -> {
                JSONArray jsonArrayCoordinates = new JSONArray();
                jsonArrayCoordinates.add(0, nodeDto.getX());
                jsonArrayCoordinates.add(1, nodeDto.getY());
                jsonArrayCoordinates.add(2, nodeDto.getZ());
                list.add(jsonArrayCoordinates);
            });


            if (faceDto.getFaceType().equals(Value.POLYGON)) {
                json.put(Graphic.TYPES, Value.POLYGON);
                json.put(Graphic.RINGS, list);
            } else {
                json.put(Graphic.TYPE, Value.POLYLINE);
                json.put(Graphic.PATHS, list);
            }

            String s = faceDto.getFaceSymbolRenderer();
            JSONParser parser = new JSONParser();
            JSONObject ob = (JSONObject) parser.parse(s);
            json.put(Graphic.SYMBOL, ob);
            jsonList.add(json);
        }

        for (int i = 166; i <= 197; i++) {
            JSONObject json = new JSONObject();
            List<JSONArray> list = new ArrayList<>();
            FaceDto faceDto = faceService.searchById(i);
            faceDto.getNodes().forEach(nodeDto -> {
                JSONArray jsonArrayCoordinates = new JSONArray();
                jsonArrayCoordinates.add(0, nodeDto.getX());
                jsonArrayCoordinates.add(1, nodeDto.getY());
                jsonArrayCoordinates.add(2, nodeDto.getZ());
                list.add(jsonArrayCoordinates);
            });

            if (faceDto.getFaceType().equals(Value.POLYGON)) {
                json.put(Graphic.TYPES, Value.POLYGON);
                json.put(Graphic.RINGS, list);
            } else {
                json.put(Graphic.TYPE, Value.POLYLINE);
                json.put(Graphic.PATHS, list);
            }

            String s = faceDto.getFaceSymbolRenderer();
            JSONParser parser = new JSONParser();
            JSONObject ob = (JSONObject) parser.parse(s);
            json.put(Graphic.SYMBOL, ob);
            jsonList.add(json);
        }

        return jsonList;
    }

    @GetMapping("/api/bitexco.geojson")
    @SuppressWarnings("unchecked")
    public JSONObject getBitexcoGeoJson() {
        BodyDto body = bodyService.searchById(1);
        JSONObject featureCollection = new JSONObject();
        JSONArray features = new JSONArray();
        List<JSONArray> list = new ArrayList<>();
        for (int i = 97; i <= 165; i++) {
            JSONArray coordinates = new JSONArray();
            FaceDto faceDto = faceService.searchById(i);
            faceDto.getNodes().forEach(nodeDto -> {
                JSONArray jsonArrayCoordinates = new JSONArray();
                jsonArrayCoordinates.add(0, nodeDto.getX());
                jsonArrayCoordinates.add(1, nodeDto.getY());
                jsonArrayCoordinates.add(2, nodeDto.getZ());
                list.add(jsonArrayCoordinates);
            });
            coordinates.add(list);
            JSONObject geometry = new JSONObject();
            geometry.put(Graphic.TYPE, Value.POLYGON_CAP);
            geometry.put(Graphic.COORDINATES, coordinates);

            JSONObject properties = new JSONObject();
            int a = i - 97;
            properties.put("Building name", "Floor " + a + " Bitexco Financial");
            properties.put(Building.HEIGHT, body.getBodyHeight());
            properties.put(Building.COLOR, body.getBodyColor());

            JSONObject feature = new JSONObject();
            feature.put(Graphic.TYPE, Value.FEATURE);
            feature.put(Graphic.PROPERTIES, properties);
            feature.put(Graphic.GEOMETRY, geometry);

            features.add(feature);
        }
        featureCollection.put(Graphic.FEATURES, features);
        featureCollection.put(Graphic.TYPE, Value.FEATURE_COLLECTION);
        return featureCollection;
    }

    @GetMapping("/api/bitexco_khung1.geojson")
    @SuppressWarnings("unchecked")
    public JSONObject getBitexcoGeoJson2() {
        BodyDto body = bodyService.searchById(1);
        JSONObject featureCollection = new JSONObject();
        JSONArray features = new JSONArray();
        for (int i = 80; i <= 95; i++) {
            List<JSONArray> list = new ArrayList<>();
            JSONArray coordinates = new JSONArray();
            FaceDto faceDto = faceService.searchById(i);
            faceDto.getNodes().forEach(nodeDto -> {
                JSONArray jsonArrayCoordinates = new JSONArray();
                jsonArrayCoordinates.add(0, nodeDto.getX());
                jsonArrayCoordinates.add(1, nodeDto.getY());
                jsonArrayCoordinates.add(2, nodeDto.getZ());
                list.add(jsonArrayCoordinates);
            });

            coordinates.add(list);
            JSONObject geometry = new JSONObject();
            geometry.put(Graphic.TYPE, Value.POLYGON_CAP);
            geometry.put(Graphic.COORDINATES, coordinates);

            JSONObject properties = new JSONObject();
            properties.put("Name", "Khung Bitexco Financial");
            properties.put(Building.HEIGHT, body.getBodyHeight());
            properties.put(Building.COLOR, body.getBodyColor());

            JSONObject feature = new JSONObject();
            feature.put(Graphic.TYPE, Value.FEATURE);
            feature.put(Graphic.PROPERTIES, properties);
            feature.put(Graphic.GEOMETRY, geometry);

            features.add(feature);
        }
        featureCollection.put(Graphic.FEATURES, features);
        featureCollection.put(Graphic.TYPE, Value.FEATURE_COLLECTION);
        return featureCollection;
    }


    @GetMapping("/api/bitexco_hanhchinh1_geojson")
    @SuppressWarnings("unchecked")
    public JSONObject getBitexcoGeoJson3() {
        BodyDto body = bodyService.searchById(1);
        JSONObject featureCollection = new JSONObject();
        JSONArray features = new JSONArray();
        for (int i = 67; i <= 78; i++) {
            JSONArray coordinates = new JSONArray();
            List<JSONArray> list = new ArrayList<>();
            FaceDto faceDto = faceService.searchById(i);
            faceDto.getNodes().forEach(nodeDto -> {
                JSONArray jsonArrayCoordinates = new JSONArray();
                jsonArrayCoordinates.add(0, nodeDto.getX());
                jsonArrayCoordinates.add(1, nodeDto.getY());
                jsonArrayCoordinates.add(2, nodeDto.getZ());
                list.add(jsonArrayCoordinates);
            });
            coordinates.add(list);
            JSONObject geometry = new JSONObject();
            geometry.put(Graphic.TYPE, Value.POLYGON_CAP);
            geometry.put(Graphic.COORDINATES, coordinates);

            JSONObject properties = new JSONObject();
            properties.put(Building.NAME, BUILDING_DESCRIPTION);
            properties.put(Building.HEIGHT, body.getBodyHeight());
            properties.put(Building.COLOR, body.getBodyColor());

            JSONObject feature = new JSONObject();
            feature.put(Graphic.TYPE, "Feature");
            feature.put(Graphic.PROPERTIES, properties);
            feature.put(Graphic.GEOMETRY, geometry);

            features.add(feature);
        }
        featureCollection.put(Graphic.FEATURES, features);
        featureCollection.put(Graphic.TYPE, Value.FEATURE_COLLECTION);
        return featureCollection;
    }


    @GetMapping("/api/bitexco_hanhchinh_geojson")
    @SuppressWarnings("unchecked")
    public JSONObject getBitexcoGeoJson4() {
        BodyDto body = bodyService.searchById(1);
        JSONObject featureCollection = new JSONObject();
        JSONArray features = new JSONArray();
        for (int i = 49; i <= 66; i++) {
            JSONArray coordinates = new JSONArray();
            List<JSONArray> list = new ArrayList<>();
            FaceDto faceDto = faceService.searchById(i);
            faceDto.getNodes().forEach(nodeDto -> {
                JSONArray jsonArrayCoordinates = new JSONArray();
                jsonArrayCoordinates.add(0, nodeDto.getX());
                jsonArrayCoordinates.add(1, nodeDto.getY());
                jsonArrayCoordinates.add(2, nodeDto.getZ());
                list.add(jsonArrayCoordinates);
            });
            coordinates.add(list);
            JSONObject geometry = new JSONObject();
            geometry.put(Graphic.TYPE, Value.POLYGON_CAP);
            geometry.put(Graphic.COORDINATES, coordinates);

            JSONObject properties = new JSONObject();
            properties.put(Building.NAME, BUILDING_DESCRIPTION);
            properties.put(Building.HEIGHT, body.getBodyHeight());
            properties.put(Building.COLOR, body.getBodyColor());

            JSONObject feature = new JSONObject();
            feature.put(Graphic.TYPE, Value.FEATURE);
            feature.put(Graphic.PROPERTIES, properties);
            feature.put(Graphic.GEOMETRY, geometry);

            features.add(feature);
        }
        featureCollection.put(Graphic.FEATURES, features);
        featureCollection.put(Graphic.TYPE, Value.FEATURE_COLLECTION);
        return featureCollection;
    }


    @GetMapping("/api/bitexco_sanbay.geojson")
    @SuppressWarnings("unchecked")
    public JSONObject getBitexcoGeoJson5() {
        BodyDto body = bodyService.searchById(1);
        JSONObject featureCollection = new JSONObject();
        JSONArray features = new JSONArray();
        for (int i = 96; i <= 96; i++) {
            JSONArray coordinates = new JSONArray();
            List<JSONArray> list = new ArrayList<>();
            FaceDto faceDto = faceService.searchById(i);
            faceDto.getNodes().forEach(nodeDto -> {
                JSONArray jsonArrayCoordinates = new JSONArray();
                jsonArrayCoordinates.add(0, nodeDto.getX());
                jsonArrayCoordinates.add(1, nodeDto.getY());
                jsonArrayCoordinates.add(2, nodeDto.getZ());
                list.add(jsonArrayCoordinates);
            });
            coordinates.add(list);
            JSONObject geometry = new JSONObject();
            geometry.put(Graphic.TYPE, Value.POLYGON_CAP);
            geometry.put(Graphic.COORDINATES, coordinates);

            JSONObject properties = new JSONObject();
            properties.put(Building.NAME, BUILDING_DESCRIPTION);
            properties.put(Building.HEIGHT, body.getBodyHeight());
            properties.put(Building.COLOR, body.getBodyColor());

            JSONObject feature = new JSONObject();
            feature.put(Graphic.TYPE, Value.FEATURE);
            feature.put(Graphic.PROPERTIES, properties);
            feature.put(Graphic.GEOMETRY, geometry);

            features.add(feature);
        }
        featureCollection.put(Graphic.FEATURES, features);
        featureCollection.put(Graphic.TYPE, Value.FEATURE_COLLECTION);
        return featureCollection;
    }


    @GetMapping("/api/bitexco_hanhchinh_bao.geojson")
    @SuppressWarnings("unchecked")
    public JSONObject getBitexcoGeoJson6() {
        BodyDto body = bodyService.searchById(1);
        JSONObject featureCollection = new JSONObject();
        JSONArray features = new JSONArray();
        for (int i = 47; i <= 48; i++) {
            JSONArray coordinates = new JSONArray();
            List<JSONArray> list = new ArrayList<>();
            FaceDto faceDto = faceService.searchById(i);
            faceDto.getNodes().forEach(nodeDto -> {
                JSONArray jsonArrayCoordinates = new JSONArray();
                jsonArrayCoordinates.add(0, nodeDto.getX());
                jsonArrayCoordinates.add(1, nodeDto.getY());
                jsonArrayCoordinates.add(2, nodeDto.getZ());
                list.add(jsonArrayCoordinates);
            });
            coordinates.add(list);
            JSONObject geometry = new JSONObject();
            geometry.put(Graphic.TYPE, Value.POLYGON_CAP);
            geometry.put(Graphic.COORDINATES, coordinates);

            JSONObject properties = new JSONObject();
            properties.put(Building.NAME, BUILDING_DESCRIPTION);
            properties.put(Building.HEIGHT, body.getBodyHeight());
            properties.put(Building.COLOR, body.getBodyColor());

            JSONObject feature = new JSONObject();
            feature.put(Graphic.TYPE, Value.FEATURE);
            feature.put(Graphic.PROPERTIES, properties);
            feature.put(Graphic.GEOMETRY, geometry);

            features.add(feature);
        }
        featureCollection.put(Graphic.FEATURES, features);
        featureCollection.put(Graphic.TYPE, Value.FEATURE_COLLECTION);
        return featureCollection;
    }
}
