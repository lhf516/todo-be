package com.fungtech.todolist.Model.Base;

import java.util.Date;

public abstract class BaseModel {
  private Date createdAt = new Date();
  private Date deletedAt;

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(Date deletedAt) {
    this.deletedAt = deletedAt;
  }
}
