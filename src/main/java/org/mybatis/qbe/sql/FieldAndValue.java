/**
 *    Copyright 2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.qbe.sql;

/**
 * A field value pair used to render insert and update statements.
 * 
 * In an insert statement it is used in the field list and value clauses.  For
 * example:
 *   insert into Bar (foo) values(?)
 * 
 * In an update statement it is used to render the set clause.  For example: 
 *   set foo = ?
 * 
 * @author Jeff Butler
 *
 * @param <T>
 */
public class FieldAndValue<T> {
    private T value;
    private SqlField<T> field;
    
    private FieldAndValue() {
        super();
    }
    
    public T getValue() {
        return value;
    }

    public SqlField<T> getField() {
        return field;
    }
    
    public FieldAndValue<T> ignoringAlias() {
        return FieldAndValue.of(field.ignoringAlias(), value);
    }
    
    public static <S> FieldAndValue<S> of(SqlField<S> field, S value) {
        FieldAndValue<S> phrase = new FieldAndValue<>();
        phrase.value = value;
        phrase.field = field;
        return phrase;
    }
}