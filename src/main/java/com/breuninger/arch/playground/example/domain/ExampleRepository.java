package com.breuninger.arch.playground.example.domain;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.breuninger.arch.playground.common.domain.JongoMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import de.otto.edison.mongo.AbstractMongoRepository;
import de.otto.edison.mongo.configuration.MongoProperties;

@Repository
public class ExampleRepository extends AbstractMongoRepository<String, Example> {

  private final MongoCollection<Document> collection;

  public ExampleRepository(final MongoDatabase mongoDatabase, final MongoProperties mongoProperties) {
    super(mongoProperties);
    collection = mongoDatabase.getCollection("examples");
  }

  @Override
  protected MongoCollection<Document> collection() {
    return collection;
  }

  @Override
  protected String keyOf(final Example example) {
    return example.getId();
  }

  @Override
  protected Document encode(final Example example) {
    return JongoMapper.encode(example);
  }

  @Override
  protected Example decode(final Document document) {
    return JongoMapper.decode(document, Example.class);
  }

  @Override
  protected void ensureIndexes() {
    //    CompletableFuture.runAsync(
    //      () -> collection().createIndex(Indexes.compoundIndex(Indexes.ascending(BOARD_ID), Indexes.descending(CREATION_DATE)),
    //        new IndexOptions().background(true)));
  }
}
