package com.breuninger.arch.playground.common.domain;

import static com.fasterxml.jackson.databind.MapperFeature.AUTO_DETECT_GETTERS;
import static com.fasterxml.jackson.databind.MapperFeature.AUTO_DETECT_IS_GETTERS;

import org.bson.Document;
import org.jongo.Mapper;
import org.jongo.bson.Bson;
import org.jongo.bson.BsonDocument;
import org.jongo.marshall.jackson.JacksonMapper.Builder;

import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class JongoMapper {

  private static final Mapper JONGO_MAPPER = new Builder()
    .disable(AUTO_DETECT_GETTERS)
    .disable(AUTO_DETECT_IS_GETTERS)
    .build();

  public static <T> Document encode(final T pojo) {
    return toDocument(JONGO_MAPPER.getMarshaller().marshall(pojo));
  }

  public static <T> T decode(final Document document, final Class<T> clazz) {
    return JONGO_MAPPER.getUnmarshaller().unmarshall(toBsonDocument(document), clazz);
  }

  private static Document toDocument(final BsonDocument bsonDocument) {
    // TODO: when jongo adds mongo 3.0 support adjust this statement - can be much shorter
    return Document.parse(JSON.serialize(bsonDocument.toDBObject()));
  }

  private static BsonDocument toBsonDocument(final Document document) {
    // TODO: when jongo adds mongo 3.0 support adjust this statement - can be much shorter
    // Do NOT use JSON.parse, since it has bugs which wont be fixed since it is superseded by JsonReader (JAVA-1841)
    final var dbObject = new BasicDBObject();
    document.forEach(dbObject::put);
    return Bson.createDocument(dbObject);
  }
}
