登记形式的原型模式
    作为原型模式的第二种形式，它多了一个原型管理器(PrototypeManager)角色.

    该角色的作用是：创建具体原型类的对象，并记录每一个被创建的对象。
    
两种形式的比较

　　简单形式和登记形式的原型模式各有其长处和短处。

　　如果需要创建的原型对象数目较少而且比较固定的话，可以采取第一种形式。在这种情况下，原型对象的引用可以由客户端自己保存。

　　如果要创建的原型对象数目不固定的话，可以采取第二种形式。在这种情况下，客户端不保存对原型对象的引用，这个任务被交给管理员对象。在复制一个原型对象之前，客户端可以查看管理员对象是否已经有一个满足要求的原型对象。如果有，可以直接从管理员类取得这个对象引用；如果没有，客户端就需要自行复制此原型对象。    
    
    
    
    
    

    