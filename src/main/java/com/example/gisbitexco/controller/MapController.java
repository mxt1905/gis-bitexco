package com.example.gisbitexco.controller;

import com.example.gisbitexco.dto.BodyDto;
import com.example.gisbitexco.dto.FaceDto;
import com.example.gisbitexco.service.BodyService;
import com.example.gisbitexco.service.FaceService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * MapController
 */
@Controller
@RequiredArgsConstructor
public class MapController {

    private final FaceService faceService;
    private final BodyService bodyService;

    @RequestMapping("/map")
    public ModelAndView showMap3DPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("map3d");
        return mav;
    }

    @GetMapping("/api/bitexco_json")
    @ResponseBody
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


            if (faceDto.getFaceType().equals("polygon")) {
                json.put("types", "polygon");
                json.put("rings", list);
            } else {
                json.put("type", "polyline");
                json.put("paths", list);
            }

            String s = faceDto.getFaceSymbolRenderer();
            JSONParser parser = new JSONParser();
            JSONObject ob = (JSONObject) parser.parse(s);
            json.put("symbol", ob);
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

            if (faceDto.getFaceType().equals("polygon")) {
                json.put("types", "polygon");
                json.put("rings", list);
            } else {
                json.put("type", "polyline");
                json.put("paths", list);
            }

            String s = faceDto.getFaceSymbolRenderer();
            JSONParser parser = new JSONParser();
            JSONObject ob = (JSONObject) parser.parse(s);
            json.put("symbol", ob);
            jsonList.add(json);
        }

        return jsonList;
    }

    @GetMapping("/api/bitexco.geojson")
    @ResponseBody
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
            geometry.put("type", "Polygon");
            geometry.put("coordinates", coordinates);

            JSONObject properties = new JSONObject();
            int a = i - 97;
            properties.put("Building name", "Floor " + a + "Bitexco Financial");
            properties.put("Height", body.getBodyHeight());
            properties.put("Color", body.getBodyColor());

            JSONObject feature = new JSONObject();
            feature.put("type", "Feature");
            feature.put("properties", properties);
            feature.put("geometry", geometry);

            features.add(feature);
        }
        featureCollection.put("features", features);
        featureCollection.put("type", "FeatureCollection");
        return featureCollection;
    }

    @GetMapping("/api/bitexco_khung1.geojson")
    @ResponseBody
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
            geometry.put("type", "Polygon");
            geometry.put("coordinates", coordinates);

            JSONObject properties = new JSONObject();
            properties.put("Name", "Khung Bitexco Financial");
            properties.put("Height", body.getBodyHeight());
            properties.put("color", body.getBodyColor());

            JSONObject feature = new JSONObject();
            feature.put("type", "Feature");
            feature.put("properties", properties);
            feature.put("geometry", geometry);

            features.add(feature);
        }
        featureCollection.put("features", features);
        featureCollection.put("type", "FeatureCollection");
        return featureCollection;
    }


    @GetMapping("/api/bitexco_hanhchinh1_geojson")
    @ResponseBody
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
            geometry.put("type", "Polygon");
            geometry.put("coordinates", coordinates);

            JSONObject properties = new JSONObject();
            properties.put("Name", "Tòa Hành Chính Bitexco Financial");
            properties.put("Height", body.getBodyHeight());
            properties.put("color", body.getBodyColor());

            JSONObject feature = new JSONObject();
            feature.put("type", "Feature");
            feature.put("properties", properties);
            feature.put("geometry", geometry);

            features.add(feature);
        }
        featureCollection.put("features", features);
        featureCollection.put("type", "FeatureCollection");
        return featureCollection;
    }


    @GetMapping("/api/bitexco_hanhchinh_geojson")
    @ResponseBody
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
            geometry.put("type", "Polygon");
            geometry.put("coordinates", coordinates);

            JSONObject properties = new JSONObject();
            properties.put("Name", "Tòa Hành Chính Bitexco Financial");
            properties.put("Height", body.getBodyHeight());
            properties.put("color", body.getBodyColor());

            JSONObject feature = new JSONObject();
            feature.put("type", "Feature");
            feature.put("properties", properties);
            feature.put("geometry", geometry);

            features.add(feature);
        }
        featureCollection.put("features", features);
        featureCollection.put("type", "FeatureCollection");
        return featureCollection;
    }


    @GetMapping("/api/bitexco_sanbay.geojson")
    @ResponseBody
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
            geometry.put("type", "Polygon");
            geometry.put("coordinates", coordinates);

            JSONObject properties = new JSONObject();
            properties.put("Name", "Tòa Hành Chính Bitexco Financial");
            properties.put("Height", body.getBodyHeight());
            properties.put("color", body.getBodyColor());

            JSONObject feature = new JSONObject();
            feature.put("type", "Feature");
            feature.put("properties", properties);
            feature.put("geometry", geometry);

            features.add(feature);
        }
        featureCollection.put("features", features);
        featureCollection.put("type", "FeatureCollection");
        return featureCollection;
    }


    @GetMapping("/api/bitexco_hanhchinh_bao.geojson")
    @ResponseBody
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
            geometry.put("type", "Polygon");
            geometry.put("coordinates", coordinates);

            JSONObject properties = new JSONObject();
            properties.put("Name", "Tòa Hành Chính Bitexco Financial");
            properties.put("Height", body.getBodyHeight());
            properties.put("color", body.getBodyColor());

            JSONObject feature = new JSONObject();
            feature.put("type", "Feature");
            feature.put("properties", properties);
            feature.put("geometry", geometry);

            features.add(feature);
        }
        featureCollection.put("features", features);
        featureCollection.put("type", "FeatureCollection");
        return featureCollection;
    }
}
