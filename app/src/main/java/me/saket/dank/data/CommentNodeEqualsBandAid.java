package me.saket.dank.data;

import com.google.auto.value.AutoValue;

import net.dean.jraw.models.CommentNode;

/**
 * {@link CommentNode#equals(Object)}'s equals() is buggy and often results in an endless loop.
 */
@AutoValue
public abstract class CommentNodeEqualsBandAid {

  public abstract CommentNode get();

  public static CommentNodeEqualsBandAid create(CommentNode commentNode) {
    return new AutoValue_CommentNodeEqualsBandAid(commentNode);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CommentNodeEqualsBandAid)) {
      return false;
    }
    CommentNodeEqualsBandAid that = (CommentNodeEqualsBandAid) o;
    return get().getComment().getFullName().equals(that.get().getComment().getFullName());
  }

  @Override
  public int hashCode() {
    return get().getComment().getFullName().hashCode();
  }
}
