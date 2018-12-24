package com.fangfangxu.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;


public class MongoAppender extends AppenderSkeleton {
    //定义MongoDB的连接和操作对象
    private MongoClient mongoClient;//mongodb的连接客户端
    private MongoDatabase mongoDatabase;//记录日志的数据库
    private MongoCollection<BasicDBObject> logsCollection;//记录日志的集合

    //定义MongoDB的配置参数
    private String connectionUrl;//连接mongodb的串
    private String databaseName;//数据库名
    private String collectionName;//集合名

    //重写append函数
//    根据log4j.properties中的配置创建mongodb连接
//    LoggingEvent提供getMessage()函数来获取日志消息
//    往配置的记录日志的collection中插入日志消息
    @Override
    protected void append(LoggingEvent event) {
        if(mongoDatabase == null) {
            MongoClientURI connectionString = new MongoClientURI(connectionUrl);
            mongoClient = new MongoClient(connectionString);
            mongoDatabase = mongoClient.getDatabase(databaseName);
            logsCollection = mongoDatabase.getCollection(collectionName, BasicDBObject.class);
        }
        logsCollection.insertOne((BasicDBObject) event.getMessage());
    }
//重写close函数：关闭mongodb的
    @Override
    public void close() {
        if(mongoClient != null) {
            mongoClient.close();
        }

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }

    public void setMongoDatabase(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    public MongoCollection<BasicDBObject> getLogsCollection() {
        return logsCollection;
    }

    public void setLogsCollection(MongoCollection<BasicDBObject> logsCollection) {
        this.logsCollection = logsCollection;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
}
