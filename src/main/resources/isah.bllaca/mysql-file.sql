
SELECT t.id,
       t.title,
       t.s_secret,
       t.content,
       t.senton,
       t.hidden,
       t.reported,
       t.root_id,
       t.sender_id,
       t.s_contact_name,
       t.s_contact_email,
       t.item_id,
       t.status_id,
       t.event_id,
       l.id              AS last_id,
       l.title           AS last_title,
       l.s_secret        AS last_s_secret,
       l.content         AS last_content,
       l.senton          AS last_sentOn,
       l.hidden          AS last_hidden,
       l.reported        AS last_reported,
       l.root_id         AS last_root_id,
       l.sender_id       AS last_sender_id,
       l.s_contact_name  AS last_s_contact_name,
       l.s_contact_email AS last_s_contact_email,
       l.item_id         AS last_item_id,
       l.status_id       AS last_status_id,
       l.event_id        AS last_event_id,
       last.count        AS t_count
FROM   oc_t_mmessenger_recipients r
       JOIN oc_t_mmessenger_message l
         ON l.id = r.message_id
       JOIN (SELECT Max(im.id) AS max,
                    Count(1)   AS count
             FROM   oc_t_mmessenger_message im
             GROUP  BY root_id) last
         ON r.message_id = last.max
       JOIN oc_t_mmessenger_message t
         ON t.id = l.root_id
       JOIN oc_t_mmessenger_message_labels ml
         ON ( ml.fk_i_message_id = t.id
              AND ml.fk_i_label_id = 1
              AND ml.fk_i_user_id = 2569 )
WHERE  ( r.recipient_id = 2469
          OR l.sender_id = 2469 )
ORDER  BY last.max DESC
LIMIT  0, 10