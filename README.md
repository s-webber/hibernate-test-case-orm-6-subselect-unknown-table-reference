Test case causing `UnknownTableReferenceException` when using `FetchMode.SUBSELECT`. 

https://github.com/s-webber/hibernate-test-case-orm-5-subselect-unknown-table-reference
https://hibernate.atlassian.net/browse/HHH-16212

```
Caused by: org.hibernate.sql.ast.tree.from.UnknownTableReferenceException: Unable to determine TableReference (`table_three_entity`) for `com.example.TableOneEntity(446267474892200).twos`
	at org.hibernate.sql.ast.tree.from.AbstractColumnReferenceQualifier.resolveTableReference(AbstractColumnReferenceQualifier.java:45) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.sql.ast.tree.from.ColumnReferenceQualifier.resolveTableReference(ColumnReferenceQualifier.java:16) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.loader.ast.internal.LoaderSelectBuilder.lambda$generateSubSelect$13(LoaderSelectBuilder.java:1122) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.metamodel.mapping.internal.SimpleForeignKeyDescriptor.visitTargetSelectables(SimpleForeignKeyDescriptor.java:434) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.metamodel.mapping.ForeignKeyDescriptor.visitTargetSelectables(ForeignKeyDescriptor.java:151) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.loader.ast.internal.LoaderSelectBuilder.generateSubSelect(LoaderSelectBuilder.java:1119) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.loader.ast.internal.LoaderSelectBuilder.applySubSelectRestriction(LoaderSelectBuilder.java:1084) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.loader.ast.internal.LoaderSelectBuilder.generateSelect(LoaderSelectBuilder.java:984) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.loader.ast.internal.LoaderSelectBuilder.createSubSelectFetchSelect(LoaderSelectBuilder.java:238) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.loader.ast.internal.CollectionLoaderSubSelectFetch.<init>(CollectionLoaderSubSelectFetch.java:59) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.persister.collection.AbstractCollectionPersister.createSubSelectLoader(AbstractCollectionPersister.java:854) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.persister.collection.AbstractCollectionPersister.resolveSubSelectLoader(AbstractCollectionPersister.java:849) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.persister.collection.AbstractCollectionPersister.determineLoaderToUse(AbstractCollectionPersister.java:819) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.persister.collection.AbstractCollectionPersister.initialize(AbstractCollectionPersister.java:789) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.event.internal.DefaultInitializeCollectionEventListener.onInitializeCollection(DefaultInitializeCollectionEventListener.java:75) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:107) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.internal.SessionImpl.initializeCollection(SessionImpl.java:1710) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.collection.spi.AbstractPersistentCollection.lambda$initialize$3(AbstractPersistentCollection.java:613) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.collection.spi.AbstractPersistentCollection.withTemporarySessionIfNeeded(AbstractPersistentCollection.java:265) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.collection.spi.AbstractPersistentCollection.initialize(AbstractPersistentCollection.java:611) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.collection.spi.AbstractPersistentCollection.forceInitialization(AbstractPersistentCollection.java:809) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.engine.internal.StatefulPersistenceContext.initializeNonLazyCollections(StatefulPersistenceContext.java:998) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.engine.internal.StatefulPersistenceContext.initializeNonLazyCollections(StatefulPersistenceContext.java:984) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.sql.results.spi.ListResultsConsumer.consume(ListResultsConsumer.java:225) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.sql.results.spi.ListResultsConsumer.consume(ListResultsConsumer.java:33) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.sql.exec.internal.JdbcSelectExecutorStandardImpl.doExecuteQuery(JdbcSelectExecutorStandardImpl.java:443) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.sql.exec.internal.JdbcSelectExecutorStandardImpl.executeQuery(JdbcSelectExecutorStandardImpl.java:166) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.sql.exec.internal.JdbcSelectExecutorStandardImpl.list(JdbcSelectExecutorStandardImpl.java:91) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.sql.exec.spi.JdbcSelectExecutor.list(JdbcSelectExecutor.java:31) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.lambda$new$0(ConcreteSqmSelectQueryPlan.java:113) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.withCacheableSqmInterpretation(ConcreteSqmSelectQueryPlan.java:335) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.performList(ConcreteSqmSelectQueryPlan.java:276) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.query.sqm.internal.QuerySqmImpl.doList(QuerySqmImpl.java:571) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	at org.hibernate.query.spi.AbstractSelectionQuery.list(AbstractSelectionQuery.java:363) ~[hibernate-core-6.1.6.Final.jar:6.1.6.Final]
	... 9 common frames omitted
```
