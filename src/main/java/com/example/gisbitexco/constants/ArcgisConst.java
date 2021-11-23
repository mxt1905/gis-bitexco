package com.example.gisbitexco.constants;

/**
 * ArcgisConst
 */
public final class ArcgisConst {

    ArcgisConst() {
    }

    public static final class Attribute {

        Attribute() {
        }

        public static final class Building {

            Building() {
            }

            public static final String NAME = "Name";
            public static final String COLOR = "Color";
            public static final String HEIGHT = "Height";
        }


        public static final class Graphic {

            Graphic() {
            }

            public static final String TYPES = "types";
            public static final String TYPE = "type";
            public static final String RINGS = "rings";
            public static final String COORDINATES = "coordinates";
            public static final String PATHS = "path";
            public static final String SYMBOL = "symbol";
            public static final String PROPERTIES = "properties";
            public static final String GEOMETRY = "geometry";
            public static final String FEATURES = "features";
        }
    }


    public static class Value {

        Value() {
        }

        public static final String POLYGON = "polygon";
        public static final String POLYGON_CAP = "Polygon";
        public static final String POLYLINE = "polyline";
        public static final String FEATURE_CAP = "Feature";
        public static final String FEATURE_COLLECTION = "FeatureCollection";
    }
}
